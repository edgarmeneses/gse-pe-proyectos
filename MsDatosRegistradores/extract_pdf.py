import sys
try:
    import PyPDF2
    
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\ms-datos-registradores\Microservicio MsDatosRegistradores.pdf"
    output_path = r"c:\Users\edgar.meneses\Documents\Repos\ms-datos-registradores\extracted_pdf.txt"
    
    with open(pdf_path, 'rb') as file:
        reader = PyPDF2.PdfReader(file)
        text = ""
        for page in reader.pages:
            text += page.extract_text() + "\n\n"
    
    with open(output_path, 'w', encoding='utf-8') as output:
        output.write(text)
    
    print(f"Texto extraído exitosamente a {output_path}")
    print(f"Total de páginas: {len(reader.pages)}")
    
except ImportError:
    print("PyPDF2 no está instalado. Instalando...")
    import subprocess
    subprocess.check_call([sys.executable, "-m", "pip", "install", "PyPDF2"])
    print("PyPDF2 instalado. Por favor ejecuta el script nuevamente.")
except Exception as e:
    print(f"Error: {str(e)}")
