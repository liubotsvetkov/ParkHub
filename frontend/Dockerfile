FROM node:lts-alpine

WORKDIR /app

COPY package.json ./

COPY . .

RUN npm cache clean --force

RUN rm -rf node_modules

RUN rm -rf package-lock.json

RUN npm install

EXPOSE 8080

CMD ["npm", "run", "serve"]