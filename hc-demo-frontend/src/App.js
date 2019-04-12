import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { AgGridReact } from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham.css';

class App extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      applications: [],
      gridOptions: {
        getRowClass: function(params) {
          return params.data['TARGET'] === 1 ? "credit-default" : "credit-ok";
        },
        columnDefs: [
          {headerName: 'SK_ID_CURR', field: 'SK_ID_CURR', sortable: true, filter: true},
          {headerName: 'NAME_CONTRACT_TYPE', field: 'NAME_CONTRACT_TYPE', sortable: true, filter: true},
          {headerName: 'CODE_GENDER', field: 'CODE_GENDER', sortable: true, filter: true},
          {headerName: 'FLAG_OWN_CAR', field: 'FLAG_OWN_CAR', sortable: true, filter: true},
          {headerName: 'FLAG_OWN_REALTY', field: 'FLAG_OWN_REALTY', sortable: true, filter: true},
          {headerName: 'CNT_CHILDREN', field: 'CNT_CHILDREN', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'AMT_INCOME_TOTAL', field: 'AMT_INCOME_TOTAL', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'AMT_CREDIT', field: 'AMT_CREDIT', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'AMT_ANNUITY', field: 'AMT_ANNUITY', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'AMT_GOODS_PRICE', field: 'AMT_GOODS_PRICE', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'NAME_TYPE_SUITE', field: 'NAME_TYPE_SUITE', sortable: true, filter: true},
          {headerName: 'NAME_INCOME_TYPE', field: 'NAME_INCOME_TYPE', sortable: true, filter: true},
          {headerName: 'NAME_EDUCATION_TYPE', field: 'NAME_EDUCATION_TYPE', sortable: true, filter: true},
          {headerName: 'NAME_FAMILY_STATUS', field: 'NAME_FAMILY_STATUS', sortable: true, filter: true},
          {headerName: 'NAME_HOUSING_TYPE', field: 'NAME_HOUSING_TYPE', sortable: true, filter: true},
          {headerName: 'REGION_POPULATION_RELATIVE', field: 'REGION_POPULATION_RELATIVE', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'DAYS_BIRTH', field: 'DAYS_BIRTH', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'DAYS_EMPLOYED', field: 'DAYS_EMPLOYED', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'DAYS_REGISTRATION', field: 'DAYS_REGISTRATION', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'DAYS_ID_PUBLISH', field: 'DAYS_ID_PUBLISH', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'OWN_CAR_AGE', field: 'OWN_CAR_AGE', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'FLAG_MOBIL', field: 'FLAG_MOBIL', sortable: true, filter: true},
          {headerName: 'FLAG_EMP_PHONE', field: 'FLAG_EMP_PHONE', sortable: true, filter: true},
          {headerName: 'FLAG_WORK_PHONE', field: 'FLAG_WORK_PHONE', sortable: true, filter: true},
          {headerName: 'FLAG_CONT_MOBILE', field: 'FLAG_CONT_MOBILE', sortable: true, filter: true},
          {headerName: 'FLAG_PHONE', field: 'FLAG_PHONE', sortable: true, filter: true},
          {headerName: 'FLAG_EMAIL', field: 'FLAG_EMAIL', sortable: true, filter: true},
          {headerName: 'OCCUPATION_TYPE', field: 'OCCUPATION_TYPE', sortable: true, filter: true},
          {headerName: 'CNT_FAM_MEMBERS', field: 'CNT_FAM_MEMBERS', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'REGION_RATING_CLIENT', field: 'REGION_RATING_CLIENT', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'REGION_RATING_CLIENT_W_CITY', field: 'REGION_RATING_CLIENT_W_CITY', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'WEEKDAY_APPR_PROCESS_START', field: 'WEEKDAY_APPR_PROCESS_START', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'HOUR_APPR_PROCESS_START', field: 'HOUR_APPR_PROCESS_START', sortable: true, filter: 'agNumberColumnFilter'},
          {headerName: 'REG_REGION_NOT_LIVE_REGION', field: 'REG_REGION_NOT_LIVE_REGION', sortable: true, filter: 'agNumberColumnFilter'},
        ]
      },
    };
  }

  componentDidMount() {
    fetch('/api/application')
      .then(res => res.json())
      .then(res => {
        this.setState({
          isLoaded: true,
          applications: res
        })
      })
  }

  render() {
    return (
      <div 
        className="ag-theme-balham"
        style={{ 
        height: '100%', 
        width: '100%' }} 
      >
        <AgGridReact
          gridOptions={this.state.gridOptions}
          rowData={this.state.applications}>
        </AgGridReact>
      </div>
    );
  }
}

export default App;
