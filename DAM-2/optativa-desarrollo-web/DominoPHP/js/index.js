// Obtencion de elementos de la pagina
const tituloInsertar = document.getElementById("titulo");
const productoInsertar = document.getElementById("producto");

const botonInsertar = document.querySelector(".btInsertar");

const tituloEditar = document.getElementById("tituloEditar");
const productoEditar = document.getElementById("productoEditar");

const botonEditar = document.querySelector(".btEditar");


//Valido los datos campos y botones individualmente ya que no sé que vamos a querer hacer en el futuro y asi está mas encapsulado creo yo
// Funcion para cambiar el css del borde del input dependiendo si es valido o no.
function validarInput(input) {
    const texto = input.value.trim();
    
    if (texto === "" || texto.length > 50) {
        input.classList.remove("input-valido");
        input.classList.add("input-invalido")
        return false;
    } else {
        input.classList.remove("input-invalido");
        input.classList.add("input-valido");
        return true;
    }
}

// Desactiva los botones dependiendo si es valido o no.
function comprobarFormularioInsertar() {
    const tituloEsValido = tituloInsertar.value.trim() !== "" || tituloInsertar.trim.length > 50;
    const productoEsvalido = productoInsertar.value.trim() !== "" || productoInsertar.trim.length > 50;

    botonInsertar.disabled = !(tituloEsValido && productoEsvalido);
}

function comprobarFormularioEditar() {
    const tituloEsValido = tituloEditar.value.trim() !== "" || tituloEditar.trim.length > 50;
    const productoEsvalido = productoEditar.value.trim() !== "" || productoEditar.trim.length > 50;

    botonEditar.disabled = !(tituloEsValido && productoEsvalido);
}


// Cada input es verificado (posteriormente puedo cambiar que se verifica por cada input)
tituloInsertar.addEventListener("input", () => {
    validarInput(tituloInsertar);
    comprobarFormularioInsertar();
});

productoInsertar.addEventListener("input", () => {
    validarInput(productoInsertar);
    comprobarFormularioInsertar();
});

tituloEditar.addEventListener("input", () => {
    validarInput(tituloEditar);
    comprobarFormularioEditar();
});

productoEditar.addEventListener("input", () => {
    validarInput(productoEditar);
    comprobarFormularioEditar();
});



// Valida los datos al pulsar el boton de insertar.
function validarBotonInsertar() {
    const valorTitulo = tituloInsertar.value.trim();
    const valorProducto = productoInsertar.value.trim();

    if (valorTitulo === "" || valorProducto === "") {
        alert(" ERROR: Tiene que rellenar todos los campos antes de insertar.");
        comprobarFormularioInsertar();
    } else if (valorTitulo.length >  50 || valorProducto.length > 50) {
        alert(" ERROR: El producto tiene que ser de 50 caracteres o menos.");
        comprobarFormularioInsertar();
    } else {
        alert(" Datos validados correctamente.");
    }
}

// Valida los datos al pulsar el boton de editar.
function validarBotonEditar() {
    const valorTitulo = tituloEditar.value.trim();
    const valorProducto = productoEditar.value.trim();

    if (valorTitulo === "" || valorProducto === "") {
        alert(" ERROR: Tiene que rellenar todos los campos antes de insertar.");
        comprobarFormularioEditar();
    } else if (valorTitulo.length >  50 || valorProducto.length > 50) {
        alert(" ERROR: El producto tiene que ser de 50 caracteres o menos.");
        comprobarFormularioEditar();
    } else {
        alert(" Datos validados correctamente.");
    }
}

botonInsertar.addEventListener("click", (validarBotonInsertar));
botonEditar.addEventListener("click", (validarBotonEditar));
