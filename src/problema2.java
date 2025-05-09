import javax.swing.JOptionPane;

public class problema2 {

    public static void main(String[] args) {
        int mulinoPA = 0, mulinoPO = 0, mulinoCH = 0, mulinoCO = 0;
        int lombanaPA = 0, lombanaPO = 0, lombanaCH = 0, lombanaCO = 0;
        int torrijosPA = 0, torrijosPO = 0, torrijosCH = 0, torrijosCO = 0;

        int votBlancos = 0;

        JOptionPane.showMessageDialog(null, "Bienvenido al tribunal electoral");

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION) {
            boolean salir = false;

            while (!salir) {
                String menu1 = """
                              Seleccione una opción:
                              1. Votar
                              2. Mostrar menu - Conteo de votos por provincia
                              3. Mostrar menu de votos totales
                              4. Mostrar menu de votos de blanco
                              5. Salir""";

                String seleccion = JOptionPane.showInputDialog(null, menu1, "Menú principal del Tribunal Electoral", JOptionPane.QUESTION_MESSAGE);

                if (seleccion == null || seleccion.equals("5")) {
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Programa finalizado!");
                } else {
                    switch (seleccion) {
                        case "1":
                            boolean continuar1 = true;

                            while (continuar1) {
                                String menu2 = """
                                    Seleccione un candidato
                                    1. Jose Raul Mulino
                                    2. Ricardo Lombana
                                    3. Martin Torrijos
                                    4. Volver al menu principal""";

                                String continuar2 = JOptionPane.showInputDialog(null, menu2, "Menu de candidatos", JOptionPane.QUESTION_MESSAGE);

                                if (continuar2 == null || continuar2.equals("4")) {
                                    continuar1 = false;
                                    continue;
                                }

                                String candidatElegido;
                                switch (continuar2) {
                                    case "1":
                                        candidatElegido = "Jose Raul Mulino";
                                        break;
                                    case "2":
                                        candidatElegido = "Ricardo Lombana";
                                        break;
                                    case "3":
                                        candidatElegido = "Martin Torrijos";
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                        continue;
                                }

                                String menu3 = """
                                    Seleccione una provincia:
                                    1. Provincia de Panamá
                                    2. Provincia de Panamá Oeste
                                    3. Provincia de Chiriquí
                                    4. Provincia de Colón
                                    5. Volver al menu principal""";

                                String continuar3 = JOptionPane.showInputDialog(null, menu3, "Menu de Provincias", JOptionPane.QUESTION_MESSAGE);

                                if (continuar3 == null || continuar3.equals("5")) {
                                    continuar1 = false;
                                    continue;
                                }

                                String provElegida;
                                switch (continuar3) {
                                    case "1":
                                        provElegida = "Provincia de Panamá";
                                        break;
                                    case "2":
                                        provElegida = "Provincia de Panamá Oeste";
                                        break;
                                    case "3":
                                        provElegida = "Provincia de Chiriquí";
                                        break;
                                    case "4":
                                        provElegida = "Provincia de Colón";
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opción invalida");
                                        continue;
                                }

                                String votosCant = JOptionPane.showInputDialog("Cuantos votos ingresas para " + candidatElegido + " en la provincia de " + provElegida + "?");

                                if (votosCant == null) {
                                    continue;
                                }

                                int cantidad;

                                try {
                                    cantidad = Integer.parseInt(votosCant);
                                    if (cantidad <= 0) {
                                        throw new NumberFormatException();
                                    }

                                    if (candidatElegido.equals("Jose Raul Mulino")) {
                                        switch (continuar3) {
                                            case "1":
                                                mulinoPA += cantidad;
                                                break;
                                            case "2":
                                                mulinoPO += cantidad;
                                                break;
                                            case "3":
                                                mulinoCH += cantidad;
                                                break;
                                            case "4":
                                                mulinoCO += cantidad;
                                                break;
                                        }
                                    } else if (candidatElegido.equals("Ricardo Lombana")) {
                                        switch (continuar3) {
                                            case "1":
                                                lombanaPA += cantidad;
                                                break;
                                            case "2":
                                                lombanaPO += cantidad;
                                                break;
                                            case "3":
                                                lombanaCH += cantidad;
                                                break;
                                            case "4":
                                                lombanaCO += cantidad;
                                                break;
                                        }
                                    } else if (candidatElegido.equals("Martin Torrijos")) {
                                        switch (continuar3) {
                                            case "1" -> torrijosPA += cantidad;
                                            case "2" -> torrijosPO += cantidad;
                                            case "3" -> torrijosCH += cantidad;
                                            case "4" -> torrijosCO += cantidad;
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Cantidad invalida, vuelva a poner la cantidad!");
                                    continue;
                                }

                                JOptionPane.showMessageDialog(null, "Se registraron " + cantidad + " votos para:\n" + " Cantidado: " + candidatElegido + "\n " + "Provincia: " + provElegida);
                            }
                            break;
                        case "2":
                            String conteo = "VOTOS POR PROVINCIA EN ORDEN DE MAYOR A MENOR\n";

                            conteo += "\nProvincia de Panamá\n";
                            if (mulinoPA >= lombanaPA && mulinoPA >= torrijosPA) {
                                conteo += "1- José Raúl Mulino: " + mulinoPA + " votos\n";
                                if (lombanaPA >= torrijosPA) {
                                    conteo += "2- Ricardo Lombana: " + lombanaPA + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosPA + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosPA + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaPA + " votos\n";
                                }
                            } else if (lombanaPA >= mulinoPA && lombanaPA >= torrijosPA) {
                                conteo += "1- Ricardo Lombana: " + lombanaPA + " votos\n";
                                if (mulinoPA >= torrijosPA) {
                                    conteo += "2- José Raúl Mulino: " + mulinoPA + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosPA + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosPA + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoPA + " votos\n";
                                }
                            } else {
                                conteo += "1- Martin Torrijos: " + torrijosPA + " votos\n";
                                if (mulinoPA >= lombanaPA) {
                                    conteo += "2- José Raúl Mulino: " + mulinoPA + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaPA + " votos\n";
                                } else {
                                    conteo += "2- Ricardo Lombana: " + lombanaPA + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoPA + " votos\n";
                                }
                            }

                            conteo += "\nProvincia de Panamá Oeste\n";
                            if (mulinoPO >= lombanaPO && mulinoPO >= torrijosPO) {
                                conteo += "1- José Raúl Mulino: " + mulinoPO + " votos\n";
                                if (lombanaPO >= torrijosPO) {
                                    conteo += "2- Ricardo Lombana: " + lombanaPO + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosPO + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosPO + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaPO + " votos\n";
                                }
                            } else if (lombanaPO >= mulinoPO && lombanaPO >= torrijosPO) {
                                conteo += "1- Ricardo Lombana: " + lombanaPO + " votos\n";
                                if (mulinoPO >= torrijosPO) {
                                    conteo += "2- José Raúl Mulino: " + mulinoPO + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosPO + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosPO + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoPO + " votos\n";
                                }
                            } else {
                                conteo += "1- Martin Torrijos: " + torrijosPO + " votos\n";
                                if (mulinoPO >= lombanaPO) {
                                    conteo += "2- José Raúl Mulino: " + mulinoPO + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaPO + " votos\n";
                                } else {
                                    conteo += "2- Ricardo Lombana: " + lombanaPO + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoPO + " votos\n";
                                }
                            }

                            conteo += "\nProvincia de Chiriquí\n";
                            if (mulinoCH >= lombanaCH && mulinoCH >= torrijosCH) {
                                conteo += "1- José Raúl Mulino: " + mulinoCH + " votos\n";
                                if (lombanaCH >= torrijosCH) {
                                    conteo += "2- Ricardo Lombana: " + lombanaCH + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosCH + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosCH + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaCH + " votos\n";
                                }
                            } else if (lombanaCH >= mulinoCH && lombanaCH >= torrijosCH) {
                                conteo += "1- Ricardo Lombana: " + lombanaCH + " votos\n";
                                if (mulinoCH >= torrijosCH) {
                                    conteo += "2- José Raúl Mulino: " + mulinoCH + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosCH + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosCH + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoCH + " votos\n";
                                }
                            } else {
                                conteo += "1- Martin Torrijos: " + torrijosCH + " votos\n";
                                if (mulinoCH >= lombanaCH) {
                                    conteo += "2- José Raúl Mulino: " + mulinoCH + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaCH + " votos\n";
                                } else {
                                    conteo += "2- Ricardo Lombana: " + lombanaCH + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoCH + " votos\n";
                                }
                            }

                            conteo += "\nProvincia de Colón\n";
                            if (mulinoCO >= lombanaCO && mulinoCO >= torrijosCO) {
                                conteo += "1- José Raúl Mulino: " + mulinoCO + " votos\n";
                                if (lombanaCO >= torrijosCO) {
                                    conteo += "2- Ricardo Lombana: " + lombanaCO + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosCO + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosCO + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaCO + " votos\n";
                                }
                            } else if (lombanaCO >= mulinoCO && lombanaCO >= torrijosCO) {
                                conteo += "1- Ricardo Lombana: " + lombanaCO + " votos\n";
                                if (mulinoCO >= torrijosCO) {
                                    conteo += "2- José Raúl Mulino: " + mulinoCO + " votos\n";
                                    conteo += "3- Martin Torrijos: " + torrijosCO + " votos\n";
                                } else {
                                    conteo += "2- Martin Torrijos: " + torrijosCO + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoCO + " votos\n";
                                }
                            } else {
                                conteo += "1- Martin Torrijos: " + torrijosCO + " votos\n";
                                if (mulinoCO >= lombanaCO) {
                                    conteo += "2- José Raúl Mulino: " + mulinoCO + " votos\n";
                                    conteo += "3- Ricardo Lombana: " + lombanaCO + " votos\n";
                                } else {
                                    conteo += "2- Ricardo Lombana: " + lombanaCO + " votos\n";
                                    conteo += "3- José Raúl Mulino: " + mulinoCO + " votos\n";
                                }
                            }

                            JOptionPane.showMessageDialog(null, conteo);
                            break;

                        case "3":
                            int mulinoTotales = mulinoPA + mulinoPO + mulinoCH + mulinoCO;
                            int lombanaTotales = lombanaPA + lombanaPO + lombanaCH + lombanaCO;
                            int torrijosTotales = torrijosPA + torrijosPO + torrijosCH + torrijosCO;

                            String resultado = "MENU DE LOS CANDIDATOS MAS VOTADOS\n";

                            if (mulinoTotales >= lombanaTotales && mulinoTotales >= torrijosTotales) {
                                resultado += "1. José Raúl Mulino: " + mulinoTotales + " votos\n";
                                if (lombanaTotales >= torrijosTotales) {
                                    resultado += "2. Ricardo Lombana: " + lombanaTotales + " votos\n";
                                    resultado += "3. Martin Torrijos: " + torrijosTotales + " votos\n";
                                } else {
                                    resultado += "2. Martin Torrijos: " + torrijosTotales + " votos\n";
                                    resultado += "3. Ricardo Lombana: " + lombanaTotales + " votos\n";
                                }
                            } else if (lombanaTotales >= mulinoTotales && lombanaTotales >= torrijosTotales) {
                                resultado += "1. Ricardo Lombana: " + lombanaTotales + " votos\n";
                                if (mulinoTotales >= torrijosTotales) {
                                    resultado += "2. José Raúl Mulino: " + mulinoTotales + " votos\n";
                                    resultado += "3. Martin Torrijos: " + torrijosTotales + " votos\n";
                                } else {
                                    resultado += "2. Martin Torrijos: " + torrijosTotales + " votos\n";
                                    resultado += "3. José Raúl Mulino: " + mulinoTotales + " votos\n";
                                }
                            } else {
                                resultado += "1. Martin Torrijos: " + torrijosTotales + " votos\n";
                                if (mulinoTotales >= lombanaTotales) {
                                    resultado += "2. José Raúl Mulino: " + mulinoTotales + " votos\n";
                                    resultado += "3. Ricardo Lombana: " + lombanaTotales + " votos\n";
                                } else {
                                    resultado += "2. Ricardo Lombana: " + lombanaTotales + " votos\n";
                                    resultado += "3. José Raúl Mulino: " + mulinoTotales + " votos\n";
                                }
                            }

                            JOptionPane.showMessageDialog(null, resultado);
                            break;
                        case "4":
                            JOptionPane.showMessageDialog(null, "📄 VOTOS EN BLANCO: " + votBlancos);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opción invalida, Intente de nuevo.");
                    }
                }
            }
        }
    }
}
