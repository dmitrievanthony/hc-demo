# HomeCredit Default Risk Scoring With Apache Ignite Demo

HomeCredit Default Risk Scoring (see [Kaggle competition](https://www.kaggle.com/c/home-credit-default-risk)) with Apache Ignite demonstration.

## How to build and start?

```
cd hc-demo-backend
mvn clean package

cd ../hc-demo-frontend
npm run build

cd ..
docker-compose build
docker-compose up
```
