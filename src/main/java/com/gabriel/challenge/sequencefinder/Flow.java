package com.gabriel.challenge.sequencefinder;

import com.gabriel.challenge.sequencefinder.utils.ResourceManipulator;
import com.gabriel.challenge.sequencefinder.utils.SequenceAssembler;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Flow {
    @Autowired
    ResourceManipulator resourceManipulator;

    @Autowired
    SequenceAssembler sequenceAssembler;

    void introduce() {
        System.out.println("- PROGRAMA INICIADO! -");
        System.out.println("DADO UM ARQUIVO CONTENDO UMA SEQUENCIA NUMÉRICA ESTE PROGRAMA APRESENTARÁ A MAIOR SEQUENCIA DE NUMEROS PRIMOS DE ATÉ 4 DIGITOS");
        System.out.println(" CONTIDOS NAS CASAS DECIMAIS DA SEQUENCIA INFORMADA (SEPARE COM . E NÃO ,)");
        System.out.println("DIGITE ABAIXO O CAMINHO PARA O ARQUIVO DESEJADO, OU DIGITE 'DEFAULT' PARA UTILIZAR O ARQUIVO PADRÃO (PI COM 1 MILHÃO DE CASAS DECIMAIS)");
    }

    String processFile(Path originalPath) {
        Path path = originalPath;

        while (path == null) {
            this.errorWithInput();
            path = getPath();
        }

        String longestSequence = "";

        try {
            String content = Files.readString(path);
            longestSequence = sequenceAssembler.getLongestPrimeSequence(content);
        } catch (IOException e) {
            System.out.println("HM... ISSO NÃO DEVERIA ACONTECER.");
            System.out.println("POR FAVOR ENTRE EM CONTATO COMIGO E ME DIGA QUAIS OS PASSOS QUE VOCÊ SEGUIU PARA CHEGAR AQUI.");
            e.printStackTrace();
        }

        return longestSequence;
    }

    void presentResult(String result) {
        System.out.println("PROCESSO FINALIZADO!");
        System.out.println("A MAIOR SEQUENCIA DE NÚMEROS PRIMOS QUE ENCONTREI FOI: ");
        System.out.println(result);
    }

    Path getPath() {
        String textInput = new Scanner(System.in).next().replace("\\", "/").replace("\u202A", "");
        Path filePath = null;

        if (textInput.toUpperCase().trim().equals("DEFAULT")) {
            filePath = resourceManipulator.getPathToResource("pi.txt");
        } else if (new File(textInput).exists()) {
            filePath = Paths.get(textInput);
        }

        return filePath;
    }

    private void errorWithInput() {
        System.out.println("OPA! ALGO DEU ERRADO COM O ARQUIVO QUE VOCÊ QUERIA!");
        System.out.println("POR FAVOR CONFIRA SE O CAMINHO DIGITADO ESTÁ CORRETO E TENTE NOVAMENTE.");
        System.out.println("(OU DIGITE 'DEFAULT' E UTILIZE O ARQUIVO PADRÃO)");

    }
}
