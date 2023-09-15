package personal.vankhulup.lestonks

import personal.vankhulup.api.StonksApiComponent
import personal.vankhulup.dbsqldelight.di.DatabaseComponent

interface SharedComponent: DatabaseComponent, StonksApiComponent {

}