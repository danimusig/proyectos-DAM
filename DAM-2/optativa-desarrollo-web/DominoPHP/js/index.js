const tituloInsertar = document.getElementById("titulo");
const productoInsertar = document.getElementById("producto");

const botonInsertar = document.querySelector(".btInsertar");

const tituloEditar = document.getElementById("tituloEditar");
const productoEditar = document.getElementById("productoEditar");

const botonEditar = document.querySelector(".btEditar");

function validarInput(input) {
    const texto = input.value.trim();

    if (texto === "") {
        input.classList.remove("input-valido");
        input.classList.add("input-invalido")
        return false;
    } else {
        input.classList.remove("input-invalido");
        input.classList.add("input-valido");
        return true;
    }
}

function comprobarFormularioInsertar() {
    const esTituloOk = tituloInsertar.value.trim() !== "";
    const esProductoOk = productoInsertar.value.trim() !== "";

    // Si ambos son válidos, habilitamos el botón; si no, lo deshabilitamos
    botonInsertar.disabled = !(esTituloOk && esProductoOk);
}

function comprobarFormularioEditar() {
    const esTituloOk = tituloEditar.value.trim() !== "";
    const esProductoOk = productoEditar.value.trim() !== "";

    botonEditar.disabled = !(esTituloOk && esProductoOk);
}

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
function validarInsertar() {
    const valorTitulo = tituloInsertar.value.trim();
    const valorProducto = productoInsertar.value.trim();

    if (valorTitulo === "" || valorProducto === "") {
        alert(" ERROR: Tiene que rellenar todos los campos antes de insertar.");
    } else if (valorTitulo.length >  50) {
        alert(" ERROR: El producto tiene que ser de 50 caracteres o menos.");
    } else {
        alert(" Datos validados correctamente.");
    }
}

// Valida los datos al pulsar el boton de editar.
function validarEditar() {
    const valorTitulo = tituloEditar.value.trim();
    const valorProducto = productoEditar.value.trim();

    if (valorTitulo === "" || valorProducto === "") {
        alert(" ERROR: Tiene que rellenar todos los campos antes de insertar.");
    } else if (valorTitulo.length >  50) {
        alert(" ERROR: El producto tiene que ser de 50 caracteres o menos.");
    } else {
        alert(" Datos validados correctamente.");
    }
}

botonInsertar.addEventListener("click", (validarInsertar));
botonEditar.addEventListener("click", (validarEditar));

comprobarFormularioInsertar();
comprobarFormularioEditar();