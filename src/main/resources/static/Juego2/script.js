const puzzleContainer = document.getElementById('puzzle-container');
const shuffleButton = document.getElementById('shuffle-button');
const message = document.getElementById('message');

let positions = Array.from({ length: 16 }, (_, i) => i);
shuffle(positions);

function createPuzzle() {
    puzzleContainer.innerHTML = '';
    positions.forEach((pos, index) => {
        const piece = document.createElement('div');
        piece.classList.add('puzzle-piece');
        if (pos !== 15) {
            piece.style.backgroundImage = 'url("https://c0.klipartz.com/pngpicture/32/348/gratis-png-juegos-de-letras-para-ninos-aprendiendo-letras-para-ninos-pequenos-baby-abc-para-ninos-aprendiendo-formas-y-colores-para-ninos-pequenos-las-matematicas-del-juego-de-ninos-cuentan-thumbnail.png")';  // Reemplaza con la URL de tu imagen
            piece.style.backgroundPosition = `${-100 * (pos % 4)}px ${-100 * Math.floor(pos / 4)}px`;
            piece.textContent = pos + 1;
        } else {
            piece.style.backgroundColor = '#fff';  // La pieza vacía
        }
        piece.addEventListener('click', () => movePiece(index));
        puzzleContainer.appendChild(piece);
    });
}

function shuffle(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
}

function movePiece(index) {
    const emptyIndex = positions.indexOf(15);
    const validMoves = [emptyIndex - 1, emptyIndex + 1, emptyIndex - 4, emptyIndex + 4];

    if (validMoves.includes(index)) {
        [positions[emptyIndex], positions[index]] = [positions[index], positions[emptyIndex]];
        createPuzzle();
        checkWin();
    }
}

function checkWin() {
    for (let i = 0; i < positions.length; i++) {
        if (positions[i] !== i) {
            message.textContent = '';
            return;
        }
    }
    message.textContent = '¡Felicidades! Has completado el rompecabezas.';
}

shuffleButton.addEventListener('click', () => {
    shuffle(positions);
    createPuzzle();
    message.textContent = '';
});

createPuzzle();
