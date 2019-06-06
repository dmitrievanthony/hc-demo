# HomeCredit Default Risk Scoring With Apache Ignite Demo

The initial problem has been taken from Kaggle “Home Credit Default Risk” [problem](https://www.kaggle.com/c/home-credit-default-risk). The following entity relationship diagram describes a data model used in the problem.
![](docs/data_model.png)

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
