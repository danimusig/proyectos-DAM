// Obtencion de elementos de la pagina
const tituloInsertar = document.getElementById("titulo");
const productoInsertar = document.getElementById("producto");

const botonInsertar = document.querySelector(".btInsertar");

const tituloEditar = document.getElementById("tituloEditar");
const productoEditar = document.getElementById("productoEditar");

const botonEditar = document.querySelector(".btEditar");

let DATOS= [];

// INSERTAR PRODUCTOS

// QuerySelector busca y devuelve el primer elemento del documento HTML que coincide con un selector CSS específico.
const NOMBRE = document.querySelector("#producto");
// Establece un listener, asignando una función de tipo evento.
NOMBRE.addEventListener("keydown", teclado);


//**** FUNCIONES *****
// FUNCION teclado: RECOGE LA TECLA PULSADA.
function teclado(e)
{
        let tecla=e.key;
        if(tecla==="Enter")
        {
            leer();
        }
}

function leer()
{
    const ESCRITO=NOMBRE.value.trim();
    if(ESCRITO)
    {
        DATOS.push({"elNombre":ESCRITO, "estrellas":1})
        escribir(ESCRITO);
        
    }
}

//FUNCIÓN ESCRIBIR: MUESTRA DATOS EN PANTALLA
function escribir(valor)
{
    document.querySelector(".listaInsertar").insertAdjacentHTML("beforeend", `
        <div class="linea" goyo="${DATOS.length-1}">
            <div class="nombre">${valor}</div>
            <div class="estrellas">
                <img src = "img/estrella.png" onclick="unaMas(this)">
            </div>
        </div>
        `)
}

//FUNCION unaMas: INCREMENTE LAS ESTRELLAS DENTRO DEL DIV (CUANDO CLICAMOS EN LA ESTRELLA)
function unaMas(e) {
    let hay=e.parentNode.querySelectorAll("img").length;
    if (hay>=6) {
        hay=0;
        e.parentNode.innerHTML=`<img src="img/estrella.png" onclick="unaMas(this)">`
    }

    let indice=e.parentNode.parentNode.getAttribute("goyo");
    DATOS[indice].estrellas=++hay;
    e.parentNode.insertAdjacentHTML("beforehand", `
        <img src="img/estrella.png" onclick="unaMas(this)">
        `)
}


//FUNCION Vaciar: VACIA LOS CAMPOS Y FOCUS RELLENADOS POR USUARIO
function vaciar() 
{
    NOMBRE.value="";
    NOMBRE.focus();
}

//FUNCION insertar
function insertar()
{
    const TITULO=document.querySelector("#titulo").value.trim();
}

// VALIDACIONES

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


// FUNCTION Vaciar: Vaciar los campos y focus.
