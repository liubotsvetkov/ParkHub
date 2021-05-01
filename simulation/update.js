let kafka = require('kafka-node');
let client = new kafka.KafkaClient({kafkaHost: 'localhost:9092'});
let fs = require('fs');

let topicToCreate = [{
  topic: 'sensor_data',
  partitions: 3,
  replicationFactor: 1
}];

client.createTopics(topicToCreate, (error, result) => {
  console.log(JSON.stringify(result));
});

let HighLevelProducer = kafka.HighLevelProducer;
producer = new HighLevelProducer(client);

producer.on('ready', function () {

    let dataList = JSON.parse(fs.readFileSync('data.json', 'utf8'));
    let indexArray = [];
    let payload = [{topic: 'sensor_data', messages: ''}];

    setInterval(async () => {

        indexArray = getRandomArrIndices(dataList);
        dataList = shuffleDataList(indexArray, dataList);

        indexArray.forEach(async (index) => {
            payload[0].messages = JSON.stringify(dataList[index]);

            await producer.send(payload, function (err, data) {
                if (err) throw err;
                console.log(data);
            });
        });
    }, 5000);
});

function getRandomArrIndices(dataList) {

    let arrLength = dataList.length;
    let n = Math.floor(Math.random() * arrLength) + 1;

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