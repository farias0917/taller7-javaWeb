let btn_burguer = document.querySelector("#burger-button")

btn_burguer.addEventListener("click",function navControl(){
    let nav = document.querySelector(".navegation") 

    if (nav.className == "navegation") {
        nav.className = "navegation navegation_2"
        btn_burguer.className = "fa-solid fa-xmark"

        

    }else{
        nav.className="navegation"
        btn_burguer.className = "fa-solid fa-bars"
    }
})


