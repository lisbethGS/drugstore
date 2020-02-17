import React from 'react';

export default class DrugstoreList extends React.Component {
  props = {
    drugstores: []
  }

  render() {
    return (
      <div class="row">
        {this.props.drugstores.map(drugstore =>
          <div class="col-sm-3">
            <div class="card">
              <div class="card-body">
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Nombre local: {drugstore.NombreLocal}</li>
                  <li class="list-group-item">Dirección: {drugstore.Direccion}</li>
                  <li class="list-group-item">Teléfono:{drugstore.Telefono}</li>
                  <li class="list-group-item">Latitud:{drugstore.Latitud}</li>
                  <li class="list-group-item">Longitud:{drugstore.Longitud}</li>
                </ul>
              </div>
            </div>
          </div>)
        }

      </div>
    )
  }
}

