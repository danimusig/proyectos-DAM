/* La mayoría de los comentarios no siguen las buenas prácticas mencionadas en los vídeos
 * pero los estoy utilizando para mencionar y apuntar cosas que me he encontrado investigando y me parecen interesantes. */


// Aplica automáticamente una animación a todas las imagenes con la clase tech-logo
// No es muy eficiente para una página tan pequeña pero si que lo sería en otras donde se introduciesen muchas imágenes, o si queremos añadir funcionalidad extra a las imagenes como un menú contextual al pasar el ratón por encima, lo aplicaré en la web final de noticias.
const imageGallery = document.querySelectorAll(".tech-logo");

function hoverImageScale(imageList, scaleFactor) {
  imageList.forEach((element) => {
    element.addEventListener("mouseover", (e) => {
      if (e.target.tagName === "IMG") {
        e.target.style.transform = `scale(${scaleFactor}`;
        e.target.style.transition = "transform 0.3s";
      }
    });

    element.addEventListener("mouseout", (e) => {
      if (e.target.tagName === "IMG") {
        e.target.style.transform = "scale(1)";
      }
    });
  });
}

hoverImageScale(imageGallery, 1.25);


/* Modo oscuro */ 
const themeSwitch = document.querySelector('#theme-checkbox');
const themeText = document.getElementById('theme-text');
const currentTheme = localStorage.getItem('theme');

// Esta funcion dependiendo de el valor theme del documento cambia el texto junto al slider.
function updateThemeText(theme) {
  if (theme === 'dark') {
    themeText.textContent = "🌑 Modo oscuro 🌃"
  } else {
    themeText.textContent = "🌞 Modo claro 💡"
  }
}

// Le doy al atributo data-theme del documento el valor del tema actual
if (currentTheme) {
  document.documentElement.setAttribute('data-theme', currentTheme);
  //Si el valor es dark se actualiza el botón 
  if (currentTheme === 'dark') {
    themeSwitch.checked = true;
  };
  updateThemeText(currentTheme);
};

themeSwitch.addEventListener('change', (e) => {
  if (e.target.checked) {
    document.documentElement.setAttribute('data-theme', 'dark');
    localStorage.setItem('theme', 'dark');
    updateThemeText('dark')
  } else {
    document.documentElement.setAttribute('data-theme', 'light');
    localStorage.setItem('theme', 'light');
    updateThemeText('light')

  };
});


// Añado un campo al formulario.
const suggestionFormField = document.getElementById("messageTypeSelector");

suggestionFormField.addEventListener('change', (e) => {

  let existingSelectLabel = document.getElementById('suggestionLabel');
  let existingSelect = document.getElementById('sugestionTypeSelect');

  let selectContainer = document.querySelector('.form__selector');
  const selectedValue = e.target.value;

  if (selectedValue === "sugerencia") {
    if (!existingSelect) {
      // Si no existe ya el campo creo los elementos HTML
      const formFieldTitle = document.createElement('label');
      formFieldTitle.id = "suggestionLabel"
      formFieldTitle.setAttribute('for', 'sugestionTypeSelect');
      formFieldTitle.textContent = "Campo de sugerencia: ";

      const formSuggestionType = document.createElement('select');
      formSuggestionType.setAttribute('name', 'sugestionType');
      formSuggestionType.setAttribute('id', 'sugestionTypeSelect');

      // Creo un array con los valores de las opciones del select.
      const sugestionOptions = [
        { text: "-- Selecciona --", value: "" },
        { text: "Lenguaje de marcas", value: "markdownLanguajes" },
        { text: "Base de datos", value: "databases" },
        { text: "Programación", value: "programming" }
      ];

      // Por cada valor diferente (opcion) creo un elemento option y le doy valor.
      sugestionOptions.forEach(optionData => {
        const createdSuggestionOption = document.createElement('option');
        createdSuggestionOption.value = optionData.value;
        createdSuggestionOption.textContent = optionData.text;
        formSuggestionType.appendChild(createdSuggestionOption);

      });
      // Adjunto los elementos al contenedor
      selectContainer.appendChild(formFieldTitle);
      selectContainer.appendChild(formSuggestionType);
    }
  } else {
    // Si cambia la opcion los borro
    if (existingSelect) {
      existingSelect.remove();
    };

    if (existingSelectLabel) {
      existingSelectLabel.remove();
    };
  };
});


// Alerta cuando se envía el formulario.
const submitButton = document.getElementById("submitButton");

submitButton.addEventListener("click", (e) => {
  let suggestion = "";

  let name = document.forms['contactForm']['nameField'].value;
  let email = document.forms['contactForm']['emailField'].value;
  let messageType = document.forms['contactForm']['tipoConsulta'].value;
  if (messageType == "sugerencia") {
    suggestion = document.forms['contactForm']['sugestionType'].value;
  }
  let topic = document.forms['contactForm']['topicField'].value;
  let message = document.forms['contactForm']['message'].value;

  let errorMessage = "";
  // Solo voy a comprobar que no estén vacíos lo cual ya hace la etiqueta required de html pero así se 
  // podrían usar patrones personalizados para ver que los campos se rellenan con datos coherentes.
  if (name == "") {
    errorMessage += "- El nombre no puede estar vacío. \n"
  }

  if (email == "") {
    errorMessage += "- El email no puede estar vacío. \n"
  }

  if (messageType == "") {
    errorMessage += "- Seleccione el tipo de consulta. \n"
  }

  if (messageType == "sugerencia" && suggestion == "") {
    errorMessage += "- Seleccione el bloque de contenido que desea mejorar. \n"
  }

  if (topic == "") {
    errorMessage += "- Indica un asunto para el mensaje. \n"
  }

  if (message == "") {
    errorMessage += "- El nombre no puede estar vacío. \n"
  }

  if (errorMessage != "") {
    alert(errorMessage);
  } else if (messageType == "consulta") {
    alert("Gracias por tu consulta.");
  } else if (messageType == "sugerencia") {
    alert("Gracias por tu sugerencia.");
  }
});





