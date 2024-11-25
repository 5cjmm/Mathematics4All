const image = document.getElementById('image');
const guessInput = document.getElementById('guess');
const submitButton = document.getElementById('submit-button');
const result = document.getElementById('result');
const questionElement = document.getElementById('question');

// Array de preguntas y respuestas correctas
const questions = [
    { question: '¿Cuántos pinos hay en la imagen?', correctAnswer: 12 },
    { question: '¿Cuántos castillos hay en la imagen?', correctAnswer: 1 },
    { question: '¿Cuántos caballos hay en la imagen?', correctAnswer: 3 },
    { question: '¿Cuantas flores blancas hay en la imagen?', correctAnswer: 7},
    { question: '¿Cuantas flores rosadas hay en la imagen?', correctAnswer: 14},
    { question: '¿Cuantas torres tiene el castillo?', correctAnswer: 7}
];

let currentQuestionIndex = 0;

function showQuestion() {
    if (currentQuestionIndex < questions.length) {
        questionElement.textContent = questions[currentQuestionIndex].question;
        guessInput.value = '';
        result.textContent = '';
        guessInput.focus();
    } else {
        result.textContent = '¡Has completado todas las preguntas!';
        submitButton.disabled = true;
    }
}

submitButton.addEventListener('click', () => {
    const userGuess = parseInt(guessInput.value);
    const correctAnswer = questions[currentQuestionIndex].correctAnswer;

    if (isNaN(userGuess)) {
        result.textContent = 'Por favor, introduce un número válido.';
        result.style.color = 'red';
    } else if (userGuess === correctAnswer) {
        result.textContent = '¡Correcto! Has acertado.';
        result.style.color = 'green';
        currentQuestionIndex++;
        setTimeout(showQuestion, 2000);  // Muestra la siguiente pregunta después de 2 segundos
    } else {
        result.textContent = `Incorrecto. La respuesta correcta es ${correctAnswer}.`;
        result.style.color = 'red';
        currentQuestionIndex++;
        setTimeout(showQuestion, 2000);  // Muestra la siguiente pregunta después de 2 segundos
    }
});

// Inicializa el juego mostrando la primera pregunta
showQuestion();
