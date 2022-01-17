//express.js
    //carregar as rotas

import express from "express"
import bodyParser from 'body-parser'
//routes
import routesCarro from "../app/routes/carro.js"



export default ()=>{
    const app = express();
    app.set("port",3000)
    app.use(bodyParser.json())
    app.use(express.static('./public'))
    
    //endpoints
    routesCarro(app)


    //outros
    app.all('/*',(req,res)=>{
        res.status(404).json({menssagem:"Rota não encontrada"})
    })

    return app
}