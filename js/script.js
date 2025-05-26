const grande = document.querySelector('.grande')
const punto = document.querySelectorAll('.punto')

//Cuando hago clic en cada punto
    //Saber la posición de ese punto
    // Aplicar un transform transaleX al grande
    //QUITAR la clase acivo de TODOs puntos
    //AÑADIR la clase activo al punto que hemos hecho CLICK

//Recorrer todos los punto
punto.forEach( (cadaPunto , i)=>{
    //Asignamos un CLICK a cadaPunto
    punto[i].addEventListener('click',()=>{

        //Guardar la posición de ese PUNTO
        let posicion = i
        //Calculando el espacio que se debe DESPLAZARSE el GRANDE
        let operacion = posicion * -50
        
        //MOVEMOS el grande
        grande.style.tranform = `transalateX(${ operacion }%)`

        //Recorremos TODOS los punto
        punto.forEach((cadaPunto , i)=>{
            //Quitamos la clase ACTIVO a TODOS los punto
            punto[i].classList.remove('activo')
        })
        //Añadir la clase activo en el punto que hemos hecho CLICK
        punto[i].classList.add('activo')
    })
})