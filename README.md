# HomeCredit Default Risk Scoring With Apache Ignite Demo

The initial problem has been taken from Kaggle “Home Credit Default Risk” [problem](https://www.kaggle.com/c/home-credit-default-risk). The following entity relationship diagram describes a data model used in the problem.

![](docs/data_model.png)

This diagram contains so-called “reference data” (files bureau.csv, bureau_balance.csv, previous_application.csv, POS_CASH_balance.csv, instalments_payments.csv, and credit_card_balance.csv) and applications themselves (file application_{train|test}.csv). All these tables, including reference data and applications, contains rows so that each row is associated with a single client (or single application what is the same in this context). This fact allows us to use horizontal partitioning (sharding) to store the data in a distributed manner in a cluster. 

GridGain is a good choice for such cases. It allows to transparently partition data across nodes in your cluster and provide fault tolerance. In addition to that Apache Ignite is a processing platform and that fact is used to build a highly scalable platform for inference.

The following diagram describes a high-level architecture of the Apache Ignite datastore used to save reference data and applications as well as an inference subsystem.

![](docs/architecture.png)

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
