//createActividad
async function createActividad(){
    
    const title=document.getElementById("title").value;
    const desc=document.getElementById("desc").value;
    const date=document.getElementById("date").value;
    const resp=document.getElementById("resp").value;

    const datos = {
        titulo: title,
        descripcion: desc,
        fecha: date,
        responsable: resp
    };

    const request = await fetch('api/actividades/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    window.location.href = "index.html";
}


//updateActividad
async function updateActividad(){
    //document.getElementById("id").value="9";
    //console.log("here");
    const id=localStorage.getItem('identificador');
    const title=document.getElementById("title").value;
    const desc=document.getElementById("desc").value;
    const date=document.getElementById("date").value;
    const resp=document.getElementById("resp").value;
    //console.log("datos");
    const datos = {
        titulo: title,
        descripcion: desc,
        fecha: date,
        responsable: resp
    };
//alert("10");
//console.log("herefds");
    const request = await fetch('api/actividades/'+id, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
//alert("fds");
//console.log("789");
    window.location.href = "index.html";
}