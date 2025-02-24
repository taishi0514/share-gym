import config from '/js/apikey.js';

const API_KEY = config.apikey;

(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})({
    key : API_KEY,
    v: "weekly",
});


let map;
/** 
 * Mapの初期化
 */ 
async function initMap() {

    const { Map } = await google.maps.importLibrary("maps");

    map = new Map(document.getElementById("map"), {
        mapId: "246576955a11af50",
        center: { lat: 35.681298, lng: 139.766247 },
        zoom: 15,
    });

    loadGymMarkers();
}


async function loadGymMarkers(){

    const { InfoWindow } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    fetch("/api/gyms")
        .then(response => response.json())
        .then(data => {
            console.log(data);

            data.forEach(spot => {

                const position = { lat: spot.latitude, lng: spot.longitude };

                const marker = new AdvancedMarkerElement({
                    map,
                    position,
                    title: spot.name,
                });

                const infoWindow = new InfoWindow({
                    content: `
                        <div>
                        <h3>${spot.name}</h3>
                        <p>${spot.address}</p>
                        </div>
                        `,
                });

                marker.addListener('click', () => {
                    infoWindow.open({
                        anchor: marker,
                        map,
                    });
                });
            });
        })
        .catch(error => {
            console.error('Error fetching spots:', error);
        });
}
window.initMap = initMap;