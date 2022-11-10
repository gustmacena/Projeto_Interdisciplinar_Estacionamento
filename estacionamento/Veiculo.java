// @author Augusto Dantas - RGM: 30981573
// @author Gabriel Cardozo dos Santos - RGM: 30031249
// @author Gustavo Araújo da Costa Macena - RGM: 30981581
// @author Kauã Vinicius da Silva Cassemiro - RGM: 31675107
// @author Thiago Gomes Delirio - RGM: 31452663
// @author Vitoria Forlim Figueiredo - RGM: 31160204

/*
essa é a classe mãe veículo, que vai ter os atributos, contrutor e gets e sets para leitura e gravação dos dados
 */
public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    public Veiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
