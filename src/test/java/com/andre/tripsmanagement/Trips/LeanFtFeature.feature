#Auto generated Octane revision tag
@TID3002REV0.1.0
# language: es

@trips
Característica: Editar lista de viajes

	Escenario: Agregar viaje
		Cuando se hace clic en el botón de New
		Y se completen los campos en el formulario
		Y se haga clic en el botón Create
		Entonces se creará un nuevo viaje con la información proporcionada

	Escenario: Eliminar viaje
		Cuando se hace clic en el botón Delete de un viaje
		Entonces se eliminará el viaje de la lista

	#Esquema del escenario: Editar un viaje
	#	Cuando se hace clic en el botón Edit de un viaje
	#	Y se edite el <campo>
	#	Entonces al hacer clic en el botón Create se modificarán los cambios 
	#	
 	#	Ejemplos:
	#	|campo|
	#	|Name|
	#	|Date|



