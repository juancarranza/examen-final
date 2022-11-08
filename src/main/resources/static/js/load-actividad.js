
const activity=JSON.parse(localStorage.getItem('actividad'));
    document.getElementById("title").value=activity.titulo;
    document.getElementById("desc").value=activity.descripcion;
    document.getElementById("date").value=activity.fecha;
    document.getElementById("resp").value=activity.responsable;