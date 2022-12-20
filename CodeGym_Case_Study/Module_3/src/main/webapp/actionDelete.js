let song = '';
function referenceDeleteSong(id) {
    song = id;
    console.log(song);
}


function playAudio(name, link) {
    musics.unshift({
        id: 1,
        title: name,
        file: link,
        image:
            "https://images.unsplash.com/photo-1614624532983-4ce03382d63d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1931&q=80",
    })
    localStorage.setItem("list", (JSON.stringify(musics)))
}