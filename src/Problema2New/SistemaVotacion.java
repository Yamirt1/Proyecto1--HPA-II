package Problema2New;

import javax.swing.JOptionPane;

public class SistemaVotacion {

    // Objetos candidatos
    private candidato mulino = new candidato("Jose Raul Mulino");
    private candidato lombana = new candidato("Ricardo Lombana");
    private candidato torrijos = new candidato("Martin Torrijos");

    // Objetos provincias
    private provincia panama = new provincia("Panamá");
    private provincia panamaoeste = new provincia("Panamá Oeste");
    private provincia colon = new provincia("Colón");
    private provincia chiriqui = new provincia("Chiriquí");

    public void iniciar() {
        JOptionPane.showMessageDialog(null, "Bienvenido al tribunal electoral");

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION) {
            menuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
        }
    }

    private void menuPrincipal() {
        boolean salir = false;

        while (!salir) {
            String menu1 = """
                    Seleccione una opción:
                    1. Votar
                    2. Mostrar menu - votos totales por provincia
                    3. Mostrar menu - votos totales por candidato
                    4. Mostrar menu - votos totales en blanco por provincia
                    5. Salir
                    """;
            String seleccion = JOptionPane.showInputDialog(null, menu1, "Menú principal del Tribunal Electoral", JOptionPane.QUESTION_MESSAGE);

            if (seleccion == null || seleccion.equals("5")) {
                salir = true;
                JOptionPane.showMessageDialog(null, "Programa finalizado");
            } else {
                switch (seleccion) {
                    case "1":
                        menuVotacion();
                        break;
                    case "2":
                        mostrarVotosPorProvincia();
                        break;
                    case "3":
                        mostrarVotosTotales();
                        break;
                    case "4":
                        mostrarVotosBlancoOrdenados();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        }
    }

    private void menuVotacion() {
        boolean continuar = true;

        while (continuar) {
            String menu = """
                    Seleccione una opción:
                    1. Votar por candidato
                    2. Votar en blanco
                    3. Volver al menu princial
                    """;
            String opcion = JOptionPane.showInputDialog(null, menu, "Menú de votación", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equals("3")) {
                continuar = false;
            } else {
                switch (opcion) {
                    case "1":
                        votarPorCandidatos();
                        break;
                    case "2":
                        votarEnBlanco();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción invalida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        }
    }

    private void votarPorCandidatos() {
        String menuCandidatos = """
                Seleccione un candidato:
                1. Jose Raul Mulino
                2. Ricardo Lombana
                3. Martin Torrijos
                4. Volver
                """;
        String candidatoSeleccionado = JOptionPane.showInputDialog(null, menuCandidatos, "Menú de candidatos", JOptionPane.QUESTION_MESSAGE);

        if (candidatoSeleccionado == null || candidatoSeleccionado.equals("4")) {
            return;
        }

        //objeto tipo de candidato
        candidato candidatoVotado = null;
        switch (candidatoSeleccionado) {
            case "1":
                candidatoVotado = mulino;
                break;
            case "2":
                candidatoVotado = lombana;
                break;
            case "3":
                candidatoVotado = torrijos;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción invalida. Por favor, seleccione una opción válida.");
                return;
        }

        String menuProvincias = """
                Seleccione una provincia:
                1. Panamá
                2. Panamá Oeste
                3. Colón
                4. Chiriquí
                5. Volver
                """;
        String provinciaSeleccionada = JOptionPane.showInputDialog(null, menuProvincias, "Menú de provincias", JOptionPane.QUESTION_MESSAGE);

        if (provinciaSeleccionada == null || provinciaSeleccionada.equals("5")) {
            return;
        }

        String nombreProvincia = "";
        switch (provinciaSeleccionada) {
            case "1":
                nombreProvincia = "Panamá";
                break;
            case "2":
                nombreProvincia = "Panamá Oeste";
                break;
            case "3":
                nombreProvincia = "Colón";
                break;
            case "4":
                nombreProvincia = "Chiriquí";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción invalida. Por favor, seleccione una opción válida.");
                return;
        }

        String votosCant = JOptionPane.showInputDialog(null, "Ingrese la cantidad de votos para " + candidatoVotado.getNombre() + " en " + nombreProvincia + ":");
        if (votosCant == null) {
            return;
        }

        try {
            int cantidad = Integer.parseInt(votosCant);
            if (cantidad <= 0) {
                throw new NumberFormatException();
            }

            // se usa el metodo del objeto candidato para agregar votos
            candidatoVotado.agregarVotos(nombreProvincia, cantidad);
            JOptionPane.showMessageDialog(null, "Se registraron " + cantidad + " votos para " + candidatoVotado.getNombre() + " en " + nombreProvincia + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida.");
        }
    }

    private void votarEnBlanco() {
        String menuProvincias = """
                Seleccione una provincia para registrar votos en blanco:
                1. Panamá
                2. Panamá Oeste
                3. Colón
                4. Chiriquí
                5. Volver
                """;
        String provinciaSeleccionada = JOptionPane.showInputDialog(null, menuProvincias, "Votos en blanco", JOptionPane.QUESTION_MESSAGE);

        if (provinciaSeleccionada == null || provinciaSeleccionada.equals("5")) {
            return;
        }

        //objeto tipo de provincia
        provincia provinciaVotada = null;
        switch (provinciaSeleccionada) {
            case "1":
                provinciaVotada = panama;
                break;
            case "2":
                provinciaVotada = panamaoeste;
                break;
            case "3":
                provinciaVotada = colon;
                break;
            case "4":
                provinciaVotada = chiriqui;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                return;
        }

        String votosBlancoCant = JOptionPane.showInputDialog(null, "¿Cuántos votos en blanco desea registrar en " + provinciaVotada.getNombre() + "?");
        if (votosBlancoCant == null) {
            return;
        }

        try {
            int cantidad = Integer.parseInt(votosBlancoCant);
            if (cantidad <= 0) {
                throw new NumberFormatException();
            }

            provinciaVotada.agregarVotosBlanco(cantidad);
            JOptionPane.showMessageDialog(null, "Se registraron " + cantidad + " votos en blanco en " + provinciaVotada.getNombre() + ".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida.");
        }
    }

    private void mostrarVotosPorProvincia() {
        // Provincia de Panamá
        int votosMulino = mulino.getVotosPanama();
        int votosLombana = lombana.getVotosPanama();
        int votosTorrijos = torrijos.getVotosPanama();

        String conteo = "VOTOS POR PROVINCIA\n\nProvincia de Panamá:\n";
        if (votosMulino >= votosLombana && votosMulino >= votosTorrijos) {
            conteo += "1. José Raúl Mulino: " + votosMulino + " votos\n";
            if (votosLombana >= votosTorrijos) {
                conteo += "2. Ricardo Lombana: " + votosLombana + " votos\n";
                conteo += "3. Martin Torrijos: " + votosTorrijos + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + votosTorrijos + " votos\n";
                conteo += "3. Ricardo Lombana: " + votosLombana + " votos\n";
            }
        } else if (votosLombana >= votosMulino && votosLombana >= votosTorrijos) {
            conteo += "1. Ricardo Lombana: " + votosLombana + " votos\n";
            if (votosMulino >= votosTorrijos) {
                conteo += "2. José Raúl Mulino: " + votosMulino + " votos\n";
                conteo += "3. Martin Torrijos: " + votosTorrijos + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + votosTorrijos + " votos\n";
                conteo += "3. José Raúl Mulino: " + votosMulino + " votos\n";
            }
        } else {
            conteo += "1. Martin Torrijos: " + votosTorrijos + " votos\n";
            if (votosMulino >= votosLombana) {
                conteo += "2. José Raúl Mulino: " + votosMulino + " votos\n";
                conteo += "3. Ricardo Lombana: " + votosLombana + " votos\n";
            } else {
                conteo += "2. Ricardo Lombana: " + votosLombana + " votos\n";
                conteo += "3. José Raúl Mulino: " + votosMulino + " votos\n";
            }
        }

        // Provincia de Panamá Oeste
        int mulinoPO = mulino.getVotosPanamaOeste();
        int lombanaPO = lombana.getVotosPanamaOeste();
        int torrijosPO = torrijos.getVotosPanamaOeste();
        conteo += "\nProvincia de Panamá Oeste:\n";
        if (mulinoPO >= lombanaPO && mulinoPO >= torrijosPO) {
            conteo += "1. José Raúl Mulino: " + mulinoPO + " votos\n";
            if (lombanaPO >= torrijosPO) {
                conteo += "2. Ricardo Lombana: " + lombanaPO + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosPO + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosPO + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaPO + " votos\n";
            }
        } else if (lombanaPO >= mulinoPO && lombanaPO >= torrijosPO) {
            conteo += "1. Ricardo Lombana: " + lombanaPO + " votos\n";
            if (mulinoPO >= torrijosPO) {
                conteo += "2. José Raúl Mulino: " + mulinoPO + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosPO + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosPO + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoPO + " votos\n";
            }
        } else {
            conteo += "1. Martin Torrijos: " + torrijosPO + " votos\n";
            if (mulinoPO >= lombanaPO) {
                conteo += "2. José Raúl Mulino: " + mulinoPO + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaPO + " votos\n";
            } else {
                conteo += "2. Ricardo Lombana: " + lombanaPO + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoPO + " votos\n";
            }
        }

        // Provincia de Colón
        int mulinoCO = mulino.getVotosColon();
        int lombanaCO = lombana.getVotosColon();
        int torrijosCO = torrijos.getVotosColon();
        conteo += "\nProvincia de Colón:\n";
        if (mulinoCO >= lombanaCO && mulinoCO >= torrijosCO) {
            conteo += "1. José Raúl Mulino: " + mulinoCO + " votos\n";
            if (lombanaCO >= torrijosCO) {
                conteo += "2. Ricardo Lombana: " + lombanaCO + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosCO + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosCO + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaCO + " votos\n";
            }
        } else if (lombanaCO >= mulinoCO && lombanaCO >= torrijosCO) {
            conteo += "1. Ricardo Lombana: " + lombanaCO + " votos\n";
            if (mulinoCO >= torrijosCO) {
                conteo += "2. José Raúl Mulino: " + mulinoCO + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosCO + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosCO + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoCO + " votos\n";
            }
        } else {
            conteo += "1. Martin Torrijos: " + torrijosCO + " votos\n";
            if (mulinoCO >= lombanaCO) {
                conteo += "2. José Raúl Mulino: " + mulinoCO + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaCO + " votos\n";
            } else {
                conteo += "2. Ricardo Lombana: " + lombanaCO + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoCO + " votos\n";
            }
        }

        // Provincia de Chiriquí
        int mulinoCH = mulino.getVotosChiriqui();
        int lombanaCH = lombana.getVotosChiriqui();
        int torrijosCH = torrijos.getVotosChiriqui();
        conteo += "\nProvincia de Chiriquí:\n";
        if (mulinoCH >= lombanaCH && mulinoCH >= torrijosCH) {
            conteo += "1. José Raúl Mulino: " + mulinoCH + " votos\n";
            if (lombanaCH >= torrijosCH) {
                conteo += "2. Ricardo Lombana: " + lombanaCH + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosCH + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosCH + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaCH + " votos\n";
            }
        } else if (lombanaCH >= mulinoCH && lombanaCH >= torrijosCH) {
            conteo += "1. Ricardo Lombana: " + lombanaCH + " votos\n";
            if (mulinoCH >= torrijosCH) {
                conteo += "2. José Raúl Mulino: " + mulinoCH + " votos\n";
                conteo += "3. Martin Torrijos: " + torrijosCH + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + torrijosCH + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoCH + " votos\n";
            }
        } else {
            conteo += "1. Martin Torrijos: " + torrijosCH + " votos\n";
            if (mulinoCH >= lombanaCH) {
                conteo += "2. José Raúl Mulino: " + mulinoCH + " votos\n";
                conteo += "3. Ricardo Lombana: " + lombanaCH + " votos\n";
            } else {
                conteo += "2. Ricardo Lombana: " + lombanaCH + " votos\n";
                conteo += "3. José Raúl Mulino: " + mulinoCH + " votos\n";
            }
        }

        JOptionPane.showMessageDialog(null, conteo);
    }

    private void mostrarVotosTotales() {
        int totalMulino = mulino.getVotosPanama() + mulino.getVotosPanamaOeste() + mulino.getVotosChiriqui() + mulino.getVotosColon();
        int totalLombana = lombana.getVotosPanama() + lombana.getVotosPanamaOeste() + lombana.getVotosChiriqui() + lombana.getVotosColon();
        int totalTorrijos = torrijos.getVotosPanama() + torrijos.getVotosPanamaOeste() + torrijos.getVotosChiriqui() + torrijos.getVotosColon();

        String conteo = "VOTOS TOTALES POR CANDIDATO (MAYOR A MENOR):\n";

        if (totalMulino >= totalLombana && totalMulino >= totalTorrijos) {
            conteo += "1. José Raúl Mulino: " + totalMulino + " votos\n";
            if (totalLombana >= totalTorrijos) {
                conteo += "2. Ricardo Lombana: " + totalLombana + " votos\n";
                conteo += "3. Martin Torrijos: " + totalTorrijos + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + totalTorrijos + " votos\n";
                conteo += "3. Ricardo Lombana: " + totalLombana + " votos\n";
            }
        } else if (totalLombana >= totalMulino && totalLombana >= totalTorrijos) {
            conteo += "1. Ricardo Lombana: " + totalLombana + " votos\n";
            if (totalMulino >= totalTorrijos) {
                conteo += "2. José Raúl Mulino: " + totalMulino + " votos\n";
                conteo += "3. Martin Torrijos: " + totalTorrijos + " votos\n";
            } else {
                conteo += "2. Martin Torrijos: " + totalTorrijos + " votos\n";
                conteo += "3. José Raúl Mulino: " + totalMulino + " votos\n";
            }
        } else {
            conteo += "1. Martin Torrijos: " + totalTorrijos + " votos\n";
            if (totalMulino >= totalLombana) {
                conteo += "2. José Raúl Mulino: " + totalMulino + " votos\n";
                conteo += "3. Ricardo Lombana: " + totalLombana + " votos\n";
            } else {
                conteo += "2. Ricardo Lombana: " + totalLombana + " votos\n";
                conteo += "3. José Raúl Mulino: " + totalMulino + " votos\n";
            }
        }

        JOptionPane.showMessageDialog(null, conteo);
    }

    private void mostrarVotosBlancoOrdenados() {
        int blancoPanama = panama.getVotosBlanco();
        int blancoPanamaOeste = panamaoeste.getVotosBlanco();
        int blancoChiriqui = chiriqui.getVotosBlanco();
        int blancoColon = colon.getVotosBlanco();

        String conteoBlancos = "VOTOS EN BLANCO POR PROVINCIA (MAYOR A MENOR):\n";

        if (blancoPanama >= blancoPanamaOeste && blancoPanama >= blancoChiriqui && blancoPanama >= blancoColon) {
            conteoBlancos += "1. Panamá: " + blancoPanama + " votos\n";
            if (blancoPanamaOeste >= blancoChiriqui && blancoPanamaOeste >= blancoColon) {
                conteoBlancos += "2. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                if (blancoChiriqui >= blancoColon) {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                }
            } else if (blancoChiriqui >= blancoPanamaOeste && blancoChiriqui >= blancoColon) {
                conteoBlancos += "2. Chiriquí: " + blancoChiriqui + " votos\n";
                if (blancoPanamaOeste >= blancoColon) {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                }
            } else {
                conteoBlancos += "2. Colón: " + blancoColon + " votos\n";
                if (blancoPanamaOeste >= blancoChiriqui) {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                } else {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                }
            }
        } else if (blancoPanamaOeste >= blancoPanama && blancoPanamaOeste >= blancoChiriqui && blancoPanamaOeste >= blancoColon) {
            conteoBlancos += "1. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
            if (blancoPanama >= blancoChiriqui && blancoPanama >= blancoColon) {
                conteoBlancos += "2. Panamá: " + blancoPanama + " votos\n";
                if (blancoChiriqui >= blancoColon) {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                }
            } else if (blancoChiriqui >= blancoPanama && blancoChiriqui >= blancoColon) {
                conteoBlancos += "2. Chiriquí: " + blancoChiriqui + " votos\n";
                if (blancoPanama >= blancoColon) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            } else {
                conteoBlancos += "2. Colón: " + blancoColon + " votos\n";
                if (blancoPanama >= blancoChiriqui) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                } else {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            }
        } else if (blancoChiriqui >= blancoPanama && blancoChiriqui >= blancoPanamaOeste && blancoChiriqui >= blancoColon) {
            conteoBlancos += "1. Chiriquí: " + blancoChiriqui + " votos\n";
            if (blancoPanama >= blancoPanamaOeste && blancoPanama >= blancoColon) {
                conteoBlancos += "2. Panamá: " + blancoPanama + " votos\n";
                if (blancoPanamaOeste >= blancoColon) {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                }
            } else if (blancoPanamaOeste >= blancoPanama && blancoPanamaOeste >= blancoColon) {
                conteoBlancos += "2. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                if (blancoPanama >= blancoColon) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Colón: " + blancoColon + " votos\n";
                } else {
                    conteoBlancos += "3. Colón: " + blancoColon + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            } else {
                conteoBlancos += "2. Colón: " + blancoColon + " votos\n";
                if (blancoPanama >= blancoPanamaOeste) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                } else {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            }
        } else {
            conteoBlancos += "1. Colón: " + blancoColon + " votos\n";
            if (blancoPanama >= blancoPanamaOeste && blancoPanama >= blancoChiriqui) {
                conteoBlancos += "2. Panamá: " + blancoPanama + " votos\n";
                if (blancoPanamaOeste >= blancoChiriqui) {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                } else {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                }
            } else if (blancoPanamaOeste >= blancoPanama && blancoPanamaOeste >= blancoChiriqui) {
                conteoBlancos += "2. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                if (blancoPanama >= blancoChiriqui) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Chiriquí: " + blancoChiriqui + " votos\n";
                } else {
                    conteoBlancos += "3. Chiriquí: " + blancoChiriqui + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            } else {
                conteoBlancos += "2. Chiriquí: " + blancoChiriqui + " votos\n";
                if (blancoPanama >= blancoPanamaOeste) {
                    conteoBlancos += "3. Panamá: " + blancoPanama + " votos\n";
                    conteoBlancos += "4. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                } else {
                    conteoBlancos += "3. Panamá Oeste: " + blancoPanamaOeste + " votos\n";
                    conteoBlancos += "4. Panamá: " + blancoPanama + " votos\n";
                }
            }
        }

        JOptionPane.showMessageDialog(null, conteoBlancos);
    }
}
