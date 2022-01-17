export default {
    render: (carro)=>{
        return {
            id:     carro._id,
            nome:   carro.nome,
            marca:  carro.marca,
            placa:  carro.placa,
            ano:  carro.ano,
        }
    }

} 
