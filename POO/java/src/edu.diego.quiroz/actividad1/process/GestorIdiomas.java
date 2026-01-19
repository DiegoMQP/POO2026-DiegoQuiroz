package edu.diego.quiroz.actividad1.process;

import java.util.HashMap;
import java.util.Map;

/**
 * Gestor de idiomas de la aplicación.
 * Maneja los textos en Español, Inglés y Francés.
 */
public class GestorIdiomas {
    private static String idiomaActual = "es"; // español por defecto
    private static Map<String, Map<String, String>> traducciones = new HashMap<>();
    
    static {
        inicializarTraducciones();
    }
    
    private static void inicializarTraducciones() {
        // Español
        Map<String, String> es = new HashMap<>();
        es.put("titulo_app", "TecmiNuevos - Sistema de Ventas");
        es.put("titulo_header", "🚗 TECMINUEVOS");
        es.put("subtitulo_header", "Tu mejor elección en vehículos");
        es.put("filtrar", "Filtrar:");
        es.put("todos", "Todos");
        es.put("nuevos", "Nuevos");
        es.put("seminuevos", "Seminuevos");
        es.put("sedan", "Sedan");
        es.put("suv", "SUV");
        es.put("año", "Año");
        es.put("nuevo", "NUEVO");
        es.put("seminuevo", "SEMINUEVO");
        es.put("agregar_carrito", "Agregar al Carrito");
        es.put("carrito_titulo", "🛒 Carrito de Compras");
        es.put("total", "Total");
        es.put("vaciar_carrito", "Vaciar Carrito");
        es.put("generar_ticket", "Generar Ticket");
        es.put("vehiculo_agregado_titulo", "✓ Vehículo Agregado");
        es.put("vehiculo_agregado_msg", "agregado al carrito exitosamente");
        es.put("carrito_vacio_titulo", "⚠️ Carrito Vacío");
        es.put("carrito_vacio_msg", "No hay vehículos en el carrito. Agrega al menos un vehículo para continuar.");
        es.put("info_cliente_titulo", "📋 Información del Cliente");
        es.put("info_cliente_header", "Complete los datos del cliente");
        es.put("nombre_completo", "Nombre completo:");
        es.put("generar_ticket_btn", "✓ Generar Ticket");
        es.put("cancelar", "✕ Cancelar");
        es.put("venta_exitosa_titulo", "🎉 ¡Venta Exitosa!");
        es.put("ticket_generado", "Ticket Generado Correctamente");
        es.put("cliente", "Cliente");
        es.put("ticket", "Ticket");
        es.put("archivo_guardado", "El archivo PDF ha sido guardado como:");
        es.put("aceptar", "✓ Aceptar");
        es.put("sin_imagen", "Sin imagen");
        es.put("seleccionar_idioma", "Seleccionar Idioma");
        es.put("bienvenida", "¡Bienvenido a TecmiNuevos!");
        es.put("elegir_idioma", "Por favor, elija su idioma preferido:");
        es.put("espanol", "🇪🇸 Español");
        es.put("ingles", "🇬🇧 Inglés");
        es.put("frances", "🇫🇷 Francés");
        es.put("continuar", "Continuar");
        // Extras
        es.put("extras_titulo", "Seleccionar Extras - TecmiNuevos");
        es.put("extras_header", "✨ Personaliza tu Vehículo");
        es.put("extras_subtitulo", "Selecciona los extras para hacer único tu vehículo");
        es.put("extras_quemacocos", "Quemacocos");
        es.put("extras_quemacocos_desc", "Techo panorámico deslizable");
        es.put("extras_asientos", "Asientos de Piel");
        es.put("extras_asientos_desc", "Tapicería en piel premium");
        es.put("extras_navegacion", "Sistema de Navegación");
        es.put("extras_navegacion_desc", "GPS integrado con pantalla táctil");
        es.put("extras_camara", "Cámara de Reversa");
        es.put("extras_camara_desc", "Cámara trasera 360°");
        es.put("extras_sensores", "Sensores de Estacionamiento");
        es.put("extras_sensores_desc", "Sensores delanteros y traseros");
        es.put("extras_crucero", "Control de Crucero Adaptativo");
        es.put("extras_crucero_desc", "Control de velocidad inteligente");
        es.put("extras_carplay", "Apple CarPlay/Android Auto");
        es.put("extras_carplay_desc", "Integración con smartphone");
        es.put("extras_audio", "Sistema de Audio Premium");
        es.put("extras_audio_desc", "10 bocinas + subwoofer");
        es.put("extras_rines", "Rines de Aluminio 18\"");
        es.put("extras_rines_desc", "Rines deportivos de aleación");
        es.put("extras_led", "Iluminación LED");
        es.put("extras_led_desc", "Faros y luces LED completas");
        es.put("extras_confort", "CONFORT");
        es.put("extras_tecnologia", "TECNOLOGÍA");
        es.put("extras_seguridad", "SEGURIDAD");
        es.put("extras_entretenimiento", "ENTRETENIMIENTO");
        es.put("extras_estetica", "ESTÉTICA");
        es.put("extras_total", "Total extras: %d | Costo adicional: $%,.2f");
        es.put("extras_confirmar", "✓ Confirmar Selección");
        // PDF
        es.put("pdf_titulo", "TECMINUEVOS");
        es.put("pdf_subtitulo", "Tu mejor elección en vehículos nuevos y seminuevos");
        es.put("pdf_ticket_no", "TICKET No:");
        es.put("pdf_fecha", "FECHA:");
        es.put("pdf_cliente", "CLIENTE:");
        es.put("pdf_vendedor", "VENDEDOR:");
        es.put("pdf_vendedor_nombre", "TecmiNuevos Sales");
        es.put("pdf_vehiculo", "━━━ VEHÍCULO #%d ━━━");
        es.put("pdf_tipo", "Tipo:");
        es.put("pdf_color", "Color:");
        es.put("pdf_motor", "Motor:");
        es.put("pdf_transmision", "Transmisión:");
        es.put("pdf_combustible", "Combustible:");
        es.put("pdf_pasajeros", "Pasajeros:");
        es.put("pdf_kilometraje", "Kilometraje:");
        es.put("pdf_condicion", "Condición:");
        es.put("pdf_garantia", "Garantía:");
        es.put("pdf_garantia_fabrica", "Garantía de fábrica");
        es.put("pdf_seminuevo", "Seminuevo");
        es.put("pdf_nuevo", "0 km - Nuevo");
        es.put("pdf_extras", "\nEXTRAS INCLUIDOS:");
        es.put("pdf_precio_final", "\nPRECIO FINAL: $%.2f MXN");
        es.put("pdf_resumen", "━━━ RESUMEN FINANCIERO ━━━");
        es.put("pdf_subtotal", "Subtotal:");
        es.put("pdf_iva", "IVA (16%):");
        es.put("pdf_total_pagar", "TOTAL A PAGAR:");
        es.put("pdf_info_titulo", "ℹ️ INFORMACIÓN IMPORTANTE");
        es.put("pdf_info_garantia", "• Garantía de fábrica aplicable según el fabricante\n");
        es.put("pdf_info_precios", "• Todos los precios incluyen IVA\n");
        es.put("pdf_info_pago", "• Formas de pago: Efectivo, transferencia, crédito automotriz\n");
        es.put("pdf_info_entrega", "• Servicio de entrega a domicilio disponible\n");
        es.put("pdf_info_consulte", "• Consulte condiciones y restricciones en TecmiNuevos");
        es.put("pdf_contacto", "📍 Av. Principal #123, Ciudad | ☎️ Tel: (55) 1234-5678 | 📧 ventas@tecminuevos.com");
        es.put("pdf_web", "🌐 www.tecminuevos.com | Síguenos en redes sociales @TecmiNuevos");
        es.put("pdf_gracias", "\n¡Gracias por su compra! Esperamos verle pronto.");
        
        // Inglés
        Map<String, String> en = new HashMap<>();
        en.put("titulo_app", "TecmiNuevos - Sales System");
        en.put("titulo_header", "🚗 TECMINUEVOS");
        en.put("subtitulo_header", "Your best choice in vehicles");
        en.put("filtrar", "Filter:");
        en.put("todos", "All");
        en.put("nuevos", "New");
        en.put("seminuevos", "Pre-Owned");
        en.put("sedan", "Sedan");
        en.put("suv", "SUV");
        en.put("año", "Year");
        en.put("nuevo", "NEW");
        en.put("seminuevo", "PRE-OWNED");
        en.put("agregar_carrito", "Add to Cart");
        en.put("carrito_titulo", "🛒 Shopping Cart");
        en.put("total", "Total");
        en.put("vaciar_carrito", "Empty Cart");
        en.put("generar_ticket", "Generate Ticket");
        en.put("vehiculo_agregado_titulo", "✓ Vehicle Added");
        en.put("vehiculo_agregado_msg", "successfully added to cart");
        en.put("carrito_vacio_titulo", "⚠️ Empty Cart");
        en.put("carrito_vacio_msg", "There are no vehicles in the cart. Add at least one vehicle to continue.");
        en.put("info_cliente_titulo", "📋 Customer Information");
        en.put("info_cliente_header", "Complete customer details");
        en.put("nombre_completo", "Full name:");
        en.put("generar_ticket_btn", "✓ Generate Ticket");
        en.put("cancelar", "✕ Cancel");
        en.put("venta_exitosa_titulo", "🎉 Successful Sale!");
        en.put("ticket_generado", "Ticket Generated Successfully");
        en.put("cliente", "Customer");
        en.put("ticket", "Ticket");
        en.put("archivo_guardado", "The PDF file has been saved as:");
        en.put("aceptar", "✓ Accept");
        en.put("sin_imagen", "No image");
        en.put("seleccionar_idioma", "Select Language");
        en.put("bienvenida", "Welcome to TecmiNuevos!");
        en.put("elegir_idioma", "Please choose your preferred language:");
        en.put("espanol", "🇪🇸 Spanish");
        en.put("ingles", "🇬🇧 English");
        en.put("frances", "🇫🇷 French");
        en.put("continuar", "Continue");
        // Extras
        en.put("extras_titulo", "Select Extras - TecmiNuevos");
        en.put("extras_header", "✨ Customize Your Vehicle");
        en.put("extras_subtitulo", "Select extras to make your vehicle unique");
        en.put("extras_quemacocos", "Sunroof");
        en.put("extras_quemacocos_desc", "Sliding panoramic roof");
        en.put("extras_asientos", "Leather Seats");
        en.put("extras_asientos_desc", "Premium leather upholstery");
        en.put("extras_navegacion", "Navigation System");
        en.put("extras_navegacion_desc", "Integrated GPS with touchscreen");
        en.put("extras_camara", "Backup Camera");
        en.put("extras_camara_desc", "360° rear camera");
        en.put("extras_sensores", "Parking Sensors");
        en.put("extras_sensores_desc", "Front and rear sensors");
        en.put("extras_crucero", "Adaptive Cruise Control");
        en.put("extras_crucero_desc", "Intelligent speed control");
        en.put("extras_carplay", "Apple CarPlay/Android Auto");
        en.put("extras_carplay_desc", "Smartphone integration");
        en.put("extras_audio", "Premium Audio System");
        en.put("extras_audio_desc", "10 speakers + subwoofer");
        en.put("extras_rines", "18\" Aluminum Wheels");
        en.put("extras_rines_desc", "Sport alloy wheels");
        en.put("extras_led", "LED Lighting");
        en.put("extras_led_desc", "Complete LED headlights and taillights");
        en.put("extras_confort", "COMFORT");
        en.put("extras_tecnologia", "TECHNOLOGY");
        en.put("extras_seguridad", "SAFETY");
        en.put("extras_entretenimiento", "ENTERTAINMENT");
        en.put("extras_estetica", "AESTHETICS");
        en.put("extras_total", "Total extras: %d | Additional cost: $%,.2f");
        en.put("extras_confirmar", "✓ Confirm Selection");
        // PDF
        en.put("pdf_titulo", "TECMINUEVOS");
        en.put("pdf_subtitulo", "Your best choice in new and pre-owned vehicles");
        en.put("pdf_ticket_no", "TICKET No:");
        en.put("pdf_fecha", "DATE:");
        en.put("pdf_cliente", "CUSTOMER:");
        en.put("pdf_vendedor", "SELLER:");
        en.put("pdf_vendedor_nombre", "TecmiNuevos Sales");
        en.put("pdf_vehiculo", "━━━ VEHICLE #%d ━━━");
        en.put("pdf_tipo", "Type:");
        en.put("pdf_color", "Color:");
        en.put("pdf_motor", "Engine:");
        en.put("pdf_transmision", "Transmission:");
        en.put("pdf_combustible", "Fuel:");
        en.put("pdf_pasajeros", "Passengers:");
        en.put("pdf_kilometraje", "Mileage:");
        en.put("pdf_condicion", "Condition:");
        en.put("pdf_garantia", "Warranty:");
        en.put("pdf_garantia_fabrica", "Factory warranty");
        en.put("pdf_seminuevo", "Pre-Owned");
        en.put("pdf_nuevo", "0 km - New");
        en.put("pdf_extras", "\nINCLUDED EXTRAS:");
        en.put("pdf_precio_final", "\nFINAL PRICE: $%.2f MXN");
        en.put("pdf_resumen", "━━━ FINANCIAL SUMMARY ━━━");
        en.put("pdf_subtotal", "Subtotal:");
        en.put("pdf_iva", "VAT (16%):");
        en.put("pdf_total_pagar", "TOTAL TO PAY:");
        en.put("pdf_info_titulo", "ℹ️ IMPORTANT INFORMATION");
        en.put("pdf_info_garantia", "• Factory warranty applicable according to manufacturer\n");
        en.put("pdf_info_precios", "• All prices include VAT\n");
        en.put("pdf_info_pago", "• Payment methods: Cash, transfer, auto credit\n");
        en.put("pdf_info_entrega", "• Home delivery service available\n");
        en.put("pdf_info_consulte", "• Check terms and conditions at TecmiNuevos");
        en.put("pdf_contacto", "📍 Main Ave. #123, City | ☎️ Tel: (55) 1234-5678 | 📧 sales@tecminuevos.com");
        en.put("pdf_web", "🌐 www.tecminuevos.com | Follow us on social media @TecmiNuevos");
        en.put("pdf_gracias", "\nThank you for your purchase! We hope to see you soon.");
        
        // Francés
        Map<String, String> fr = new HashMap<>();
        fr.put("titulo_app", "TecmiNuevos - Système de Vente");
        fr.put("titulo_header", "🚗 TECMINUEVOS");
        fr.put("subtitulo_header", "Votre meilleur choix en véhicules");
        fr.put("filtrar", "Filtrer:");
        fr.put("todos", "Tous");
        fr.put("nuevos", "Nouveaux");
        fr.put("seminuevos", "D'occasion");
        fr.put("sedan", "Berline");
        fr.put("suv", "SUV");
        fr.put("año", "Année");
        fr.put("nuevo", "NOUVEAU");
        fr.put("seminuevo", "D'OCCASION");
        fr.put("agregar_carrito", "Ajouter au Panier");
        fr.put("carrito_titulo", "🛒 Panier d'Achats");
        fr.put("total", "Total");
        fr.put("vaciar_carrito", "Vider le Panier");
        fr.put("generar_ticket", "Générer le Ticket");
        fr.put("vehiculo_agregado_titulo", "✓ Véhicule Ajouté");
        fr.put("vehiculo_agregado_msg", "ajouté au panier avec succès");
        fr.put("carrito_vacio_titulo", "⚠️ Panier Vide");
        fr.put("carrito_vacio_msg", "Il n'y a pas de véhicules dans le panier. Ajoutez au moins un véhicule pour continuer.");
        fr.put("info_cliente_titulo", "📋 Informations Client");
        fr.put("info_cliente_header", "Complétez les détails du client");
        fr.put("nombre_completo", "Nom complet:");
        fr.put("generar_ticket_btn", "✓ Générer le Ticket");
        fr.put("cancelar", "✕ Annuler");
        fr.put("venta_exitosa_titulo", "🎉 Vente Réussie!");
        fr.put("ticket_generado", "Ticket Généré avec Succès");
        fr.put("cliente", "Client");
        fr.put("ticket", "Ticket");
        fr.put("archivo_guardado", "Le fichier PDF a été enregistré sous:");
        fr.put("aceptar", "✓ Accepter");
        fr.put("sin_imagen", "Pas d'image");
        fr.put("seleccionar_idioma", "Sélectionner la Langue");
        fr.put("bienvenida", "Bienvenue chez TecmiNuevos!");
        fr.put("elegir_idioma", "Veuillez choisir votre langue préférée:");
        fr.put("espanol", "🇪🇸 Espagnol");
        fr.put("ingles", "🇬🇧 Anglais");
        fr.put("frances", "🇫🇷 Français");
        fr.put("continuar", "Continuer");
        // Extras
        fr.put("extras_titulo", "Sélectionner des Extras - TecmiNuevos");
        fr.put("extras_header", "✨ Personnalisez Votre Véhicule");
        fr.put("extras_subtitulo", "Sélectionnez des extras pour rendre votre véhicule unique");
        fr.put("extras_quemacocos", "Toit Ouvrant");
        fr.put("extras_quemacocos_desc", "Toit panoramique coulissant");
        fr.put("extras_asientos", "Sièges en Cuir");
        fr.put("extras_asientos_desc", "Tapisserie en cuir premium");
        fr.put("extras_navegacion", "Système de Navigation");
        fr.put("extras_navegacion_desc", "GPS intégré avec écran tactile");
        fr.put("extras_camara", "Caméra de Recul");
        fr.put("extras_camara_desc", "Caméra arrière 360°");
        fr.put("extras_sensores", "Capteurs de Stationnement");
        fr.put("extras_sensores_desc", "Capteurs avant et arrière");
        fr.put("extras_crucero", "Régulateur de Vitesse Adaptatif");
        fr.put("extras_crucero_desc", "Contrôle de vitesse intelligent");
        fr.put("extras_carplay", "Apple CarPlay/Android Auto");
        fr.put("extras_carplay_desc", "Intégration smartphone");
        fr.put("extras_audio", "Système Audio Premium");
        fr.put("extras_audio_desc", "10 haut-parleurs + caisson de basses");
        fr.put("extras_rines", "Jantes en Aluminium 18\"");
        fr.put("extras_rines_desc", "Jantes sportives en alliage");
        fr.put("extras_led", "Éclairage LED");
        fr.put("extras_led_desc", "Phares et feux LED complets");
        fr.put("extras_confort", "CONFORT");
        fr.put("extras_tecnologia", "TECHNOLOGIE");
        fr.put("extras_seguridad", "SÉCURITÉ");
        fr.put("extras_entretenimiento", "DIVERTISSEMENT");
        fr.put("extras_estetica", "ESTHÉTIQUE");
        fr.put("extras_total", "Total extras: %d | Coût supplémentaire: $%,.2f");
        fr.put("extras_confirmar", "✓ Confirmer la Sélection");
        // PDF
        fr.put("pdf_titulo", "TECMINUEVOS");
        fr.put("pdf_subtitulo", "Votre meilleur choix en véhicules neufs et d'occasion");
        fr.put("pdf_ticket_no", "TICKET No:");
        fr.put("pdf_fecha", "DATE:");
        fr.put("pdf_cliente", "CLIENT:");
        fr.put("pdf_vendedor", "VENDEUR:");
        fr.put("pdf_vendedor_nombre", "TecmiNuevos Sales");
        fr.put("pdf_vehiculo", "━━━ VÉHICULE #%d ━━━");
        fr.put("pdf_tipo", "Type:");
        fr.put("pdf_color", "Couleur:");
        fr.put("pdf_motor", "Moteur:");
        fr.put("pdf_transmision", "Transmission:");
        fr.put("pdf_combustible", "Carburant:");
        fr.put("pdf_pasajeros", "Passagers:");
        fr.put("pdf_kilometraje", "Kilométrage:");
        fr.put("pdf_condicion", "État:");
        fr.put("pdf_garantia", "Garantie:");
        fr.put("pdf_garantia_fabrica", "Garantie d'usine");
        fr.put("pdf_seminuevo", "D'occasion");
        fr.put("pdf_nuevo", "0 km - Neuf");
        fr.put("pdf_extras", "\nEXTRAS INCLUS:");
        fr.put("pdf_precio_final", "\nPRIX FINAL: $%.2f MXN");
        fr.put("pdf_resumen", "━━━ RÉSUMÉ FINANCIER ━━━");
        fr.put("pdf_subtotal", "Sous-total:");
        fr.put("pdf_iva", "TVA (16%):");
        fr.put("pdf_total_pagar", "TOTAL À PAYER:");
        fr.put("pdf_info_titulo", "ℹ️ INFORMATIONS IMPORTANTES");
        fr.put("pdf_info_garantia", "• Garantie d'usine applicable selon le fabricant\n");
        fr.put("pdf_info_precios", "• Tous les prix incluent la TVA\n");
        fr.put("pdf_info_pago", "• Modes de paiement: Espèces, virement, crédit auto\n");
        fr.put("pdf_info_entrega", "• Service de livraison à domicile disponible\n");
        fr.put("pdf_info_consulte", "• Consultez les conditions chez TecmiNuevos");
        fr.put("pdf_contacto", "📍 Ave. Principale #123, Ville | ☎️ Tél: (55) 1234-5678 | 📧 ventes@tecminuevos.com");
        fr.put("pdf_web", "🌐 www.tecminuevos.com | Suivez-nous sur les réseaux sociaux @TecmiNuevos");
        fr.put("pdf_gracias", "\nMerci pour votre achat! Nous espérons vous revoir bientôt.");
        
        traducciones.put("es", es);
        traducciones.put("en", en);
        traducciones.put("fr", fr);
    }
    
    /**
     * Establece el idioma actual de la aplicación.
     * @param idioma Código del idioma ("es", "en", "fr")
     */
    public static void setIdioma(String idioma) {
        if (traducciones.containsKey(idioma)) {
            idiomaActual = idioma;
        }
    }
    
    /**
     * Obtiene el idioma actual.
     * @return Código del idioma actual
     */
    public static String getIdiomaActual() {
        return idiomaActual;
    }
    
    /**
     * Obtiene la traducción de una clave en el idioma actual.
     * @param clave Clave de la traducción
     * @return Texto traducido o la clave si no se encuentra
     */
    public static String t(String clave) {
        Map<String, String> idioma = traducciones.get(idiomaActual);
        return idioma.getOrDefault(clave, clave);
    }
    
    /**
     * Obtiene la traducción de una clave con formato.
     * @param clave Clave de la traducción
     * @param args Argumentos para formatear
     * @return Texto traducido y formateado
     */
    public static String tf(String clave, Object... args) {
        return String.format(t(clave), args);
    }
}
