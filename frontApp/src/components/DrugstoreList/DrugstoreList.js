import React from 'react';

export default class DrugstoreList extends React.Component {
  props = {
    drugstores: []
  }
  
  render() {
    return (
      <div id="divConteiner">
         {this.props.drugstores.map(drugstore => <div className="drugConteiner"><table >
  <tr>
    <th>Nombre local:</th>
    <td>{drugstore.NombreLocal}</td>
  </tr>
  <tr>
    <th >Direccion:</th>
    <td>{drugstore.Direccion}</td>
  </tr>
  <tr>
    <th >Telephone:</th>
    <td>{drugstore.Telefono}</td>
  </tr>
  <tr>
    <th >Latitud:</th>
    <td>{drugstore.Latitud}</td>
  </tr>
  <tr>
    <th >Longitud:</th>
    <td>{drugstore.Longitud}</td>
  </tr>
</table></div>)
         }
         </div>
    )
  }
}

