FROM node:10-alpine as builder

WORKDIR /vue-ui

COPY package.json ./

RUN npm cache clean --force

RUN rm -rf node_modules

RUN rm -rf package-lock.json

RUN npm install

COPY . .

RUN npm run build

FROM nginx:1.19-alpine as production-build
RUN mkdir /etc/nginx/templates
COPY ./.nginx/templates/default.conf.template /etc/nginx/templates/

RUN rm -rf /usr/share/nginx/html/*

COPY --from=builder /vue-ui/dist /usr/share/nginx/html

EXPOSE 8080
CMD ["nginx", "-g", "daemon off;"]