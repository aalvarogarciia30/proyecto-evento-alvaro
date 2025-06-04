document.querySelectorAll(".carrousel").forEach(carrousel => {
    const items = carrousel.querySelectorAll(".carrousel-item");
    // Nombres de los eventos (en el mismo orden que las imágenes)
    const eventNames = [
        "Feria de Sostenibilidad",
        "Conferencia EcoInnovación",
        "Jornada de reciclaje"
    ];
    // Crear el contenedor de los botones
    const nav = document.createElement("div");
    nav.className = "carrousel-nav";
    // Crear y añadir los botones
    items.forEach(() => {
        const btn = document.createElement("span");
        btn.className = "carrousel-button";
        nav.appendChild(btn);
    });
    carrousel.appendChild(nav);

    const buttons = carrousel.querySelectorAll(".carrousel-button");
    // Referencia al contenedor del título
    const titleDiv = document.getElementById("carrousel-title");
    function updateTitle(index) {
        if (titleDiv) titleDiv.textContent = eventNames[index];
    }
    buttons.forEach((button, i) => {
        button.addEventListener("click", () => {
            items.forEach(item => item.classList.remove("carrousel-item-selected"));
            buttons.forEach(button => button.classList.remove("carrousel-button-selected"));

            items[i].classList.add("carrousel-item-selected");
            button.classList.add("carrousel-button-selected");
            updateTitle(i);
        });
    });
    //Seleccionar el primer elemento y botón como seleccionado
    items[0].classList.add("carrousel-item-selected");
    buttons[0].classList.add("carrousel-button-selected");
    updateTitle(0);
});