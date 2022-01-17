import controller from '../controllers/carro.js'


export default (app)=>{
    app.get("/api/carros",controller.listarCarros)
    app.post("/api/carros",controller.inserirCarro)
    app.get("/api/carros/:id",controller.obterCarro)
    app.delete("/api/carros/:id",controller.removerCarro)
    




}