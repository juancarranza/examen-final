$(document).ready(function() {
    loadActividades();
    $('#tasks').DataTable();
});

async function loadActividades(){

    const getRequest = await fetch('api/actividades', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
    });
    const actividades = await getRequest.json();
    
    console.log(actividades);

    let actividadesTable="";
    for(let a of actividades){
        let actividadHtml=`<tr>
                        <td>${a.id}</td>
                        <td>${a.titulo}</td>
                        <td>${a.descripcion}</td>
                        <td>${a.fecha}</td>
                        <td>${a.responsable}</td>
                        <td> 
                            <a href="#" onclick="deleteActividad(${a.id})" class="btn btn-danger btn-circle btn-sm">
                                <i class="fas fa-trash"></i>
                            </a>
                            <a href="#" onclick="modificarActividad(${a.id})" class="btn btn-info btn-circle btn-sm">
                                <i class="fas fa-info-circle"></i>
                            </a>
                        </td>
                    </tr>`;

    actividadesTable+=actividadHtml;
        
    }

    document.querySelector("#tasks tbody").outerHTML=actividadesTable;
}

//deleteActividad
async function deleteActividad(id){
    const request = await fetch('api/actividades/' + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        //body: JSON.stringify({a: 1, b: 'Textual content'})
    });

    loadActividades();
}

//deleteActividad
function modificarActividad(id){
    localStorage.setItem('identificador', id);
    window.location.href = "update.html";
}

