import React from 'react';
import axios from 'axios';
import DrugstoreList from '../DrugstoreForm/Drugstore'

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
        this.setState({
          drugstores: res.data
        });
      })
  }

  render() {
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
          {this.state.drugstores ? <DrugstoreList drugstores={this.state.drugstores} /> : null}
        </form>
      </div>
    )
  }
}