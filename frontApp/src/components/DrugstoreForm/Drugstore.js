import React from 'react';
import axios from 'axios';
import DrugstoreList from '../DrugstoreList/DrugstoreList.js'
import './../../App.css';


export default class Drugstore extends React.Component {
  state = {
    locationName: '',
    drugstoreName: '',
    drugstores: []
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
    if (this.state.drugstores.length > 0) {
      result = <DrugstoreList drugstores={this.state.drugstores} />;
      console.log(result);
    }
    return (
      <div>

        <form class="contentForm" onSubmit={this.handleSubmit}>
          <div class="form-group">
            <label for="exampleFormControlInput1">Comuna:
            <input className="form-control" type="text" name="id" onChange={this.handleChangeLocation} />
            </label>
          </div>
          <div class="form-group">
            <label for="exampleFormControlInput1">Farmacia:
            <input className="form-control" type="text" name="id" onChange={this.handleChangeLocationDrugstore} />
            </label>

          </div>
          <button className="btn btn-primary" type="submit">Buscar</button>
        </form>
        {result}
      </div>
    )
  }
}
