import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class produto {

/*Crie uma classe que representa um produto. A classe deve ter os atributos, nome, marca, preço de custo e preço de venda. Deve ter também um método que calcula e retorna o lucro.
Crie objetos dessa classe e escreva na tela seus atributos e o valor do lucro.
Crie uma classe para representar pessoas. O construtor da classe deve receber como parâmetros o nome completo, altura e a data de nascimento. Os objetos, logo após criados, devem criar automaticamente um email no formato nome.sobrenome@dominio.
Desafio: A data de nascimento não pode ser posterior à data atual.
Para entrega desta atividade, crie um repositório remoto com o nome PRODUTO, preencha o README.MD conforme o modelo apresentado em aula.*/

private String nome;
private String marca;
private double precoCusto;
private double precoVenda;

public Produto(String nome, String marca, double precoCusto, double precoVenda) {
    this.nome = nome;
    this.marca = marca;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
} 

public double calcularLucro() {
    return precoVenda - precoCusto;

}

public void mostrarInformacoes() {
    double lucro = calcularLucro();
     System.out.printf("Produto: %s, Marca: %s, Preco de Custo: R$%.2f, Preco de Venda: R$%.2f, Lucro: R$%.2f%n",
                          nome, marca, precoCusto, precoVenda, lucro); 

}

} 


public class Pessoa {
    private String nomeCompleto;
    private double altura;
    private LocalDate dataNascimento;
    private String email;

    public Pessoa(String nomeCompleto, double altura, String dataNascimento) {
        this.nomeCompleto = nomeCompleto;
        this.altura = altura;
        this.dataNascimento = validarData(dataNascimento);
        this.email = gerarEmail();
    }

    private LocalDate validarData(String dataNascimento) {
        LocalDate data = LocalDate.parse(dataNascimento);
        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento nao pode ser posterior a data atual.");
        }
        return data;
    }

    private String gerarEmail() {
        String[] partes = nomeCompleto.toLowerCase().split(" ");
        return partes[0] + "." + partes[1] + "@dominio.com";
    }

    public void mostrarInformacoes() {
        System.out.printf("Nome: %s, Altura: %.2fm, Data de Nascimento: %s, Email: %s%n",
                          nomeCompleto, altura, dataNascimento, email);
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando objetos da classe Produto
        Produto produto1 = new Produto("Camiseta", "Marca A", 30.00, 50.00);
        Produto produto2 = new Produto("Calca", "Marca B", 80.00, 120.00);

        produto1.mostrarInformacoes();
        produto2.mostrarInformacoes();

        // Criando objetos da classe Pessoa
        try {
            Pessoa pessoa1 = new Pessoa("Arthur Soares", 1.75, "1995-05-20");
            Pessoa pessoa2 = new Pessoa("Luiza Penha", 1.60, "2000-08-15");

            pessoa1.mostrarInformacoes();
            pessoa2.mostrarInformacoes();
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
    }
}




 