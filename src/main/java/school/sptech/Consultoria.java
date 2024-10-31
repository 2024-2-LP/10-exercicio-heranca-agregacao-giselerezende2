package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            if (vagas > desenvolvedores.size()){
                desenvolvedores.add(desenvolvedor);
                return true;
            }

        }return false;
    }

    public Double getTotalSalarios(){
        Double contador = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            contador += desenvolvedor.calcularSalario();
        }return contador;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer contador = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile){
                contador++;
            }
        }
        return contador;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devPorSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario){
                devPorSalario.add(desenvolvedor);
            }
        }return devPorSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor desenvolvedorMenorSalario = this.desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedorMenorSalario.calcularSalario() > desenvolvedor.calcularSalario()){
                desenvolvedorMenorSalario = desenvolvedor;
            }
        }
        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresPorTecnologia = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (
                    desenvolvedor instanceof DesenvolvedorWeb &&
                    (((DesenvolvedorWeb)desenvolvedor).getBackend().equalsIgnoreCase(tecnologia) ||
                    ((DesenvolvedorWeb)desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia) ||
                    ((DesenvolvedorWeb)desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia)) ||
                            desenvolvedor instanceof DesenvolvedorMobile &&
                    (((DesenvolvedorMobile)desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia) ||
                    ((DesenvolvedorMobile)desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia))
            ) {
                desenvolvedoresPorTecnologia.add(desenvolvedor);
            }
        }
        return desenvolvedoresPorTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresPorTecnologia = buscarPorTecnologia(tecnologia);
        Double somaSalario = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedoresPorTecnologia) {
            somaSalario += desenvolvedor.calcularSalario();
        }
     return somaSalario;
    }




}
