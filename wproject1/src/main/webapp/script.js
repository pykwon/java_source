document.addEventListener('DOMContentLoaded', function() {
    const characters = {
        tracer: {
            name: '트레이서',
            img: 'https://static.wikia.nocookie.net/overwatch/images/9/9c/Tracer_portrait.png'
        },
        reaper: {
            name: '리퍼',
            img: 'https://static.wikia.nocookie.net/overwatch/images/3/39/Reaper_portrait.png'
        },
        mercy: {
            name: '메르시',
            img: 'https://static.wikia.nocookie.net/overwatch/images/6/68/Mercy_portrait.png'
        }
    };

    const characterButtons = document.querySelectorAll('.character-btn');
    const characterImage = document.getElementById('character-image');
    const characterName = document.getElementById('character-name');

    characterButtons.forEach(button => {
        button.addEventListener('click', function() {
            const characterKey = this.getAttribute('data-character');
            const character = characters[characterKey];
            characterImage.src = character.img;
            characterName.textContent = character.name;
        });
    });
});
