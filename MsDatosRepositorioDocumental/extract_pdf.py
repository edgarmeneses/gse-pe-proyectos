import sys
try:
    import PyPDF2
    with open("Microservicio MsDatosRepositorioDocumental V1.3.pdf", "rb") as file:
        reader = PyPDF2.PdfReader(file)
        text = ""
        for page in reader.pages:
            text += page.extract_text() + "\n\n"
        
        with open("PDF_EXTRACTION.txt", "w", encoding="utf-8") as output:
            output.write(text)
        print("Extracción completada en PDF_EXTRACTION.txt")
except ImportError:
    print("PyPDF2 no está instalado. Instalando...")
    sys.exit(1)
