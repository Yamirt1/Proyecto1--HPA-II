
import javax.swing.JOptionPane;

public class problema2ME {

    static int mulinoPA = 0, mulinoPO = 0, mulinoCH = 0, mulinoCO = 0;
    static int lombanaPA = 0, lombanaPO = 0, lombanaCH = 0, lombanaCO = 0;
    static int torrijosPA = 0, torrijosPO = 0, torrijosCH = 0, torrijosCO = 0;
    static int votosBlancoPA = 0, votosBlancoPO = 0, votosBlancoCH = 0, votosBlancoCO = 0;

    public static void menuPrincipal() { //1 - Metodo!
        boolean salir = false;

        while (!salir) {
            String menu1 = """
                    Seleccione una opción:
                    1. Votar
                    2. Mostrar menu - conteo de votos por provincia
                    3. Mostrar menu - votos totales por candidato
                    4. Mostar menu - votos totales en blanco por provincia
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
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                }
            }
        }
    }

    public static void menuVotacion() { //2 - Metodo!
        boolean continuar1 = true;

        while (continuar1) {
            String menu2 = """
                    Seleccione una opción:
                    1. Votar por candidatos
                    2. Votar en blanco
                    3. Volver al menú principal
                    """;

            String opcion = JOptionPane.showInputDialog(null, menu2, "Menú de votación", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equals("3")) {
                continuar1 = false;
            } else {
                switch (opcion) {
                    case "1":
                        votarPorCandidatos();
                        break;
                    case "2":
                        votarEnBlanco();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                }
            }
        }
    }

    public static void votarPorCandidatos() { //3 - Metodo!
        boolean continuar2 = true;

        while (continuar2) {
            String menuCandidatos = """
                    Seleccione una opción:
                    1. Votar por Jose Raul Mulino
                    2. Votar por Ricardo Lombana
                    3. Votar por Martin Torrijos
                    4. Volver al menú anterior
                    """;
            String candidatoSeleccionado = JOptionPane.showInputDialog(null, menuCandidatos, "Menú de candidatos", JOptionPane.QUESTION_MESSAGE);

            if (candidatoSeleccionado == null || candidatoSeleccionado.equals("4")) {
                continuar2 = false;
                continue;
            }

            String candidatElegido;
            switch (candidatoSeleccionado) {
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
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                    continue;
            }

            String menuProvincias = """
                    Seleccione una provincia:
                    1. Provincia de Panamá
                    2. Provincia de Panamá Oeste
                    3. Provincia de Chiriquí
                    4. Provincia de Colón
                    5. Volver
                    """;

            String provinciaSeleccionada = JOptionPane.showInputDialog(null, menuProvincias, "Menú de provincias", JOptionPane.QUESTION_MESSAGE);

            if (provinciaSeleccionada == null || provinciaSeleccionada.equals("5")) {
                continue;
            }

            String provElegida;
            switch (provinciaSeleccionada) {
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
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
                    continue;
            }

            String votosCant = JOptionPane.showInputDialog(null, "¿Cuántos votos desea registrar para " + candidatElegido + " en la provincia de " + provElegida + "?");

            if (votosCant == null) {
                continue;
            }

            try {
                int cantidad = Integer.parseInt(votosCant);
                if (cantidad <= 0) {
                    throw new NumberFormatException();
                }

                if (candidatElegido.equals("Jose Raul Mulino")) {
                    switch (provinciaSeleccionada) {
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
                    switch (provinciaSeleccionada) {
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
                    switch (provinciaSeleccionada) {
                        case "1":
                            torrijosPA += cantidad;
                            break;
                        case "2":
                            torrijosPO += cantidad;
                            break;
                        case "3":
                            torrijosCH += cantidad;
                            break;
                        case "4":
                            torrijosCO += cantidad;
                            break;
                    }
                }

                JOptionPane.showMessageDialog(null, "Se registraron " + cantidad + " votos para:\nCandidato: " + candidatElegido + "\nProvincia: " + provElegida);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida, vuelva a poner la cantidad.");
            }
        }
    }

    public static void votarEnBlanco() { //4 - Metodo!
        boolean continuar = true;

        while (continuar) {
            String menuProvinciasBlanco = """
                    Seleccione una provincia:
                    1. Provincia de Panamá
                    2. Provincia de Panamá Oeste
                    3. Provincia de Chiriquí
                    4. Provincia de Colón
                    5. Volver
                    """;

            String provinciaBlancoSeleccionada = JOptionPane.showInputDialog(null, menuProvinciasBlanco, "Menú de provincias", JOptionPane.QUESTION_MESSAGE);

            if (provinciaBlancoSeleccionada == null || provinciaBlancoSeleccionada.equals("5")) {
                continuar = false;
                continue;
            }

            String votosBlancoCant = JOptionPane.showInputDialog("¿Cuántos votos en blanco ingresas para la provincia seleccionada?");

            if (votosBlancoCant == null) {
                continue;
            }

            try {
                int cantidadBlanco = Integer.parseInt(votosBlancoCant);
                if (cantidadBlanco <= 0) {
                    throw new NumberFormatException();
                }

                switch (provinciaBlancoSeleccionada) {
                    case "1":
                        votosBlancoPA += cantidadBlanco;
                        break;
                    case "2":
                        votosBlancoPO += cantidadBlanco;
                        break;
                    case "3":
                        votosBlancoCH += cantidadBlanco;
                        break;
                    case "4":
                        votosBlancoCO += cantidadBlanco;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Provincia Inválida. Intente nuevamente.");
                        continue;
                }
                JOptionPane.showMessageDialog(null, "Se registraron " + cantidadBlanco + " votos en blanco para la provincia seleccionada.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida, Ponga de nuevo la cantidad.");
            }
        }
    }

    public static void mostrarVotosPorProvincia(){ //5 Metodo!

    }

    public static void mostrarVotosTotales(){ //6 metodo!

    }

    public static void mostrarVotosBlancoOrdenados(){ // 7 metodo!

    }
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al tribunal electoral");

        int respuesta1 = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta1 == JOptionPane.YES_OPTION) {
            menuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
        }
    }
}
