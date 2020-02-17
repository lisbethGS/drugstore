import React from 'react';
import axios from 'axios';
import DrugstoreList from '../DrugstoreList/DrugstoreList.js'


export default class Drugstore extends React.Component {
  state = {
    locationName: '',
    drugstoreName: '',
    drugstores:[]
  }

  handleChangeLocation = event => {
    this.setState({ locationName: event.target.value });
  }
  handleChangeLocationDrugstore = event => {
    this.setState({ drugstoreName: event.target.value });
  }

  handleSubmit = event => {
    event.preventDefault();
    axios.get(`/drugstore?locationName=${this.state.locationName}&drugstoreName=${this.state.drugstoreName}`)
      .then(res => {
        const drugstores = res.data;
        this.setState({ drugstores });
      })
  }

  render() {
    let result;
    if (this.state.drugstores.length>0) {
      result =<DrugstoreList drugstores={this.state.drugstores} />;
      console.log(result);
    }
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>
            Comuna:
            <input type="text" name="id" onChange={this.handleChangeLocation} />
          </label>
          <label>
            Farmacia:
            <input type="text" name="id" onChange={this.handleChangeLocationDrugstore} />
          </label>
          <button type="submit">Buscar</button>
        </form>
        {result}
      </div>
    )
  }
}