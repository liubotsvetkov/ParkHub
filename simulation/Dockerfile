FROM node:14

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

CMD node ./populate.js

ENTRYPOINT ["node", "./update.js"]