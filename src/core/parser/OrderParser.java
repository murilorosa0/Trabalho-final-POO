package core.parser;

import domain.model.Order;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrderParser {
    public static void main(String[] args) {
        Path file = Paths.get("src/infra/monitor/planilha.csv");

        // Usando Files.lines lazily para não carregar tudo na memória
        // Cada linha será uma stream de string que recebe a linha atual da planilha
        try (Stream<String> lines = Files.lines(file)) {
            lines.skip(1) // Pular a linha do cabeçalho
                    .map(line -> OrderParser.parseLineToOrder(line)) // Para cada linha, execute a função parseLineToOrder() passando a linha retornando um objeto ou null
                    .filter(line -> java.util.Objects.nonNull(line)) // Descartar linhas que falharam no parser
                    .forEach(order -> {
                        System.out.println("Processing valid order: " + order.getIdPedido());
                    });

        } catch (IOException e) {
            System.err.println("Failed to open or read the file: " + e.getMessage());
        }
    }

    private static Order parseLineToOrder(String line) {
        try {
            // Cria um vetor de string com cada plavra da linha
            String[] row = line.split(",");

            // Verifica se a linha possui 5 itens(completa)
            if (row.length < 5) {
                System.err.println("Skipped malformed line (insufficient columns): " + line);
                return null;
            }

            // Cria um objeto de Order com os dados da linha
            return new Order(
                    Integer.parseInt(row[0].trim()),
                    row[1].trim(),
                    row[4].trim(),
                    Double.parseDouble(row[2].trim()),
                    Double.parseDouble(row[3].trim())
            );
        } catch (NumberFormatException e) {
            // Retorna o erro, para continuar o processamento
            System.err.println("Skipped line due to invalid numeric format: " + line);
            // TODO: Here you will instantiate a Rejection object and send it to the error buffer
            return null;
        }
    }
}