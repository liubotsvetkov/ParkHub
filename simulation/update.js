let fs = require('fs');
let kafka = require('kafka-node');
let client = new kafka.KafkaClient({kafkaHost: process.env.KAFKA_HOST});
let HighLevelProducer = kafka.HighLevelProducer;
producer = new HighLevelProducer(client);

createKafkaTopic();

producer.on('ready', function () {

    let dataList = JSON.parse(fs.readFileSync('data.json', 'utf8'));
    let indexArray = [];

    setInterval(async () => {

        indexArray = getRandomArrIndices(dataList);
        dataList = shuffleDataList(indexArray, dataList);
        sendData(indexArray, dataList);

    }, 5000);
});

function getRandomArrIndices(dataList) {

    let arrLength = dataList.length;
    let n = Math.floor(Math.random() * (arrLength - 1)) + 1;

    let indexArr = [];

    while(indexArr.length < n){
        let r = Math.floor(Math.random() * arrLength);
        if (indexArr.indexOf(r) === -1) indexArr.push(r);
    }

    return indexArr;
}

function shuffleDataList(indexArray, dataList) {

    indexArray.forEach(index => {
        if (dataList[index] != null) {
            dataList[index].state = 1 - dataList[index].state;
        }
    });

    return dataList;
}

function sendData(indexArray, dataList) {

    let payload = [{topic: process.env.KAFKA_TOPIC, messages: ''}];

    indexArray.forEach(async (index) => {

        payload[0].messages = JSON.stringify(dataList[index]);

        await producer.send(payload, function (err, data) {
            if (err) throw err;
            console.log(data);
        });
    });
}

function createKafkaTopic() {

    let topicToCreate = [{
      topic: process.env.KAFKA_TOPIC,
      partitions: process.env.TOPIC_PARTITIONS,
      replicationFactor: process.env.TOPIC_REPLICATION_FACTOR
    }];

    client.createTopics(topicToCreate, (error, result) => {
      console.log(JSON.stringify(result));
    });
}