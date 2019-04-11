import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      isLoaded: false,
      applications: []
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
    const { isLoaded, applications } = this.state;
    return (
      <div className="App">
        <table>
          <tr>
            <th>SK_ID_CURR</th>
            <th>TARGET</th>
            <th>NAME_CONTRACT_TYPE</th>
            <th>CODE_GENDER</th>
            <th>FLAG_OWN_CAR</th>
            <th>FLAG_OWN_REALTY</th>
            <th>CNT_CHILDREN</th>
            <th>AMT_INCOME_TOTAL</th>
            <th>AMT_CREDIT</th>
            <th>AMT_ANNUITY</th>
            <th>AMT_GOODS_PRICE</th>
            <th>NAME_TYPE_SUITE</th>
            <th>NAME_INCOME_TYPE</th>
            <th>NAME_EDUCATION_TYPE</th>
            <th>NAME_FAMILY_STATUS</th>
            <th>NAME_HOUSING_TYPE</th>
            <th>REGION_POPULATION_RELATIVE</th>
            <th>DAYS_BIRTH</th>
            <th>DAYS_EMPLOYED</th>
            <th>DAYS_REGISTRATION</th>
            <th>DAYS_ID_PUBLISH</th>
            <th>OWN_CAR_AGE</th>
            <th>FLAG_MOBIL</th>
            <th>FLAG_EMP_PHONE</th>
            <th>FLAG_WORK_PHONE</th>
            <th>FLAG_CONT_MOBILE</th>
            <th>FLAG_PHONE</th>
            <th>FLAG_EMAIL</th>
            <th>OCCUPATION_TYPE</th>
            <th>CNT_FAM_MEMBERS</th>
            <th>REGION_RATING_CLIENT</th>
            <th>REGION_RATING_CLIENT_W_CITY</th>
            <th>WEEKDAY_APPR_PROCESS_START</th>
            <th>HOUR_APPR_PROCESS_START</th>
            <th>REG_REGION_NOT_LIVE_REGION</th>
            <th>REG_REGION_NOT_WORK_REGION</th>
            <th>LIVE_REGION_NOT_WORK_REGION</th>
            <th>REG_CITY_NOT_LIVE_CITY</th>
            <th>REG_CITY_NOT_WORK_CITY</th>
            <th>LIVE_CITY_NOT_WORK_CITY</th>
            <th>ORGANIZATION_TYPE</th>
            <th>EXT_SOURCE_1</th>
            <th>EXT_SOURCE_2</th>
            <th>EXT_SOURCE_3</th>
            <th>APARTMENTS_AVG</th>
            <th>BASEMENTAREA_AVG</th>
            <th>YEARS_BEGINEXPLUATATION_AVG</th>
            <th>YEARS_BUILD_AVG</th>
            <th>COMMONAREA_AVG</th>
            <th>ELEVATORS_AVG</th>
            <th>ENTRANCES_AVG</th>
            <th>FLOORSMAX_AVG</th>
            <th>FLOORSMIN_AVG</th>
            <th>LANDAREA_AVG</th>
            <th>LIVINGAPARTMENTS_AVG</th>
            <th>LIVINGAREA_AVG</th>
            <th>NONLIVINGAPARTMENTS_AVG</th>
            <th>NONLIVINGAREA_AVG</th>
            <th>APARTMENTS_MODE</th>
            <th>BASEMENTAREA_MODE</th>
            <th>YEARS_BEGINEXPLUATATION_MODE</th>
            <th>YEARS_BUILD_MODE</th>
            <th>COMMONAREA_MODE</th>
            <th>ELEVATORS_MODE</th>
            <th>ENTRANCES_MODE</th>
            <th>FLOORSMAX_MODE</th>
            <th>FLOORSMIN_MODE</th>
            <th>LANDAREA_MODE</th>
            <th>LIVINGAPARTMENTS_MODE</th>
            <th>LIVINGAREA_MODE</th>
            <th>NONLIVINGAPARTMENTS_MODE</th>
            <th>NONLIVINGAREA_MODE</th>
            <th>APARTMENTS_MEDI</th>
            <th>BASEMENTAREA_MEDI</th>
            <th>YEARS_BEGINEXPLUATATION_MEDI</th>
            <th>YEARS_BUILD_MEDI</th>
            <th>COMMONAREA_MEDI</th>
            <th>ELEVATORS_MEDI</th>
            <th>ENTRANCES_MEDI</th>
            <th>FLOORSMAX_MEDI</th>
            <th>FLOORSMIN_MEDI</th>
            <th>LANDAREA_MEDI</th>
            <th>LIVINGAPARTMENTS_MEDI</th>
            <th>LIVINGAREA_MEDI</th>
            <th>NONLIVINGAPARTMENTS_MEDI</th>
          </tr>
          {applications.map(application => (
            <tr>
              <td>{application['SK_ID_CURR']}</td>
              <td>{application['TARGET']}</td>
              <td>{application['NAME_CONTRACT_TYPE']}</td>
              <td>{application['CODE_GENDER']}</td>
              <td>{application['FLAG_OWN_CAR']}</td>
              <td>{application['FLAG_OWN_REALTY']}</td>
              <td>{application['CNT_CHILDREN']}</td>
              <td>{application['AMT_INCOME_TOTAL']}</td>
              <td>{application['AMT_CREDIT']}</td>
              <td>{application['AMT_ANNUITY']}</td>
              <td>{application['AMT_GOODS_PRICE']}</td>
              <td>{application['NAME_TYPE_SUITE']}</td>
              <td>{application['NAME_INCOME_TYPE']}</td>
              <td>{application['NAME_EDUCATION_TYPE']}</td>
              <td>{application['NAME_FAMILY_STATUS']}</td>
              <td>{application['NAME_HOUSING_TYPE']}</td>
              <td>{application['REGION_POPULATION_RELATIVE']}</td>
              <td>{application['DAYS_BIRTH']}</td>
              <td>{application['DAYS_EMPLOYED']}</td>
              <td>{application['DAYS_REGISTRATION']}</td>
              <td>{application['DAYS_ID_PUBLISH']}</td>
              <td>{application['OWN_CAR_AGE']}</td>
              <td>{application['FLAG_MOBIL']}</td>
              <td>{application['FLAG_EMP_PHONE']}</td>
              <td>{application['FLAG_WORK_PHONE']}</td>
              <td>{application['FLAG_CONT_MOBILE']}</td>
              <td>{application['FLAG_PHONE']}</td>
              <td>{application['FLAG_EMAIL']}</td>
              <td>{application['OCCUPATION_TYPE']}</td>
              <td>{application['CNT_FAM_MEMBERS']}</td>
              <td>{application['REGION_RATING_CLIENT']}</td>
              <td>{application['REGION_RATING_CLIENT_W_CITY']}</td>
              <td>{application['WEEKDAY_APPR_PROCESS_START']}</td>
              <td>{application['HOUR_APPR_PROCESS_START']}</td>
              <td>{application['REG_REGION_NOT_LIVE_REGION']}</td>
              <td>{application['REG_REGION_NOT_WORK_REGION']}</td>
              <td>{application['LIVE_REGION_NOT_WORK_REGION']}</td>
              <td>{application['REG_CITY_NOT_LIVE_CITY']}</td>
              <td>{application['REG_CITY_NOT_WORK_CITY']}</td>
              <td>{application['LIVE_CITY_NOT_WORK_CITY']}</td>
              <td>{application['ORGANIZATION_TYPE']}</td>
              <td>{application['EXT_SOURCE_1']}</td>
              <td>{application['EXT_SOURCE_2']}</td>
              <td>{application['EXT_SOURCE_3']}</td>
              <td>{application['APARTMENTS_AVG']}</td>
              <td>{application['BASEMENTAREA_AVG']}</td>
              <td>{application['YEARS_BEGINEXPLUATATION_AVG']}</td>
              <td>{application['YEARS_BUILD_AVG']}</td>
              <td>{application['COMMONAREA_AVG']}</td>
              <td>{application['ELEVATORS_AVG']}</td>
              <td>{application['ENTRANCES_AVG']}</td>
              <td>{application['FLOORSMAX_AVG']}</td>
              <td>{application['FLOORSMIN_AVG']}</td>
              <td>{application['LANDAREA_AVG']}</td>
              <td>{application['LIVINGAPARTMENTS_AVG']}</td>
              <td>{application['LIVINGAREA_AVG']}</td>
              <td>{application['NONLIVINGAPARTMENTS_AVG']}</td>
              <td>{application['NONLIVINGAREA_AVG']}</td>
              <td>{application['APARTMENTS_MODE']}</td>
              <td>{application['BASEMENTAREA_MODE']}</td>
              <td>{application['YEARS_BEGINEXPLUATATION_MODE']}</td>
              <td>{application['YEARS_BUILD_MODE']}</td>
              <td>{application['COMMONAREA_MODE']}</td>
              <td>{application['ELEVATORS_MODE']}</td>
              <td>{application['ENTRANCES_MODE']}</td>
              <td>{application['FLOORSMAX_MODE']}</td>
              <td>{application['FLOORSMIN_MODE']}</td>
              <td>{application['LANDAREA_MODE']}</td>
              <td>{application['LIVINGAPARTMENTS_MODE']}</td>
              <td>{application['LIVINGAREA_MODE']}</td>
              <td>{application['NONLIVINGAPARTMENTS_MODE']}</td>
              <td>{application['NONLIVINGAREA_MODE']}</td>
              <td>{application['APARTMENTS_MEDI']}</td>
              <td>{application['BASEMENTAREA_MEDI']}</td>
              <td>{application['YEARS_BEGINEXPLUATATION_MEDI']}</td>
              <td>{application['YEARS_BUILD_MEDI']}</td>
              <td>{application['COMMONAREA_MEDI']}</td>
              <td>{application['ELEVATORS_MEDI']}</td>
              <td>{application['ENTRANCES_MEDI']}</td>
              <td>{application['FLOORSMAX_MEDI']}</td>
              <td>{application['FLOORSMIN_MEDI']}</td>
              <td>{application['LANDAREA_MEDI']}</td>
              <td>{application['LIVINGAPARTMENTS_MEDI']}</td>
              <td>{application['LIVINGAREA_MEDI']}</td>
              <td>{application['NONLIVINGAPARTMENTS_MEDI']}</td>
            </tr>
          ))}
        </table>
      </div>
    );
  }
}

export default App;
