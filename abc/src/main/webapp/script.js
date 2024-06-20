document.addEventListener('DOMContentLoaded', function() {
    const links = document.querySelectorAll('.transition-link');

    links.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault();
            const target = this.href;

            document.body.classList.add('fade-out');

            setTimeout(function() {
                window.location.href = target;
            }, 500);
        });
    });

    document.body.classList.add('fade-in');
});
