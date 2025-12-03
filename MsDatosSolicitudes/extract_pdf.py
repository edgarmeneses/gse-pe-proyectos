import fitz  # PyMuPDF
import json

def extract_pdf_content(pdf_path):
    doc = fitz.open(pdf_path)
    full_text = ""
    
    for page_num in range(len(doc)):
        page = doc[page_num]
        text = page.get_text()
        full_text += f"\n--- Página {page_num + 1} ---\n"
        full_text += text
    
    doc.close()
    return full_text

if __name__ == "__main__":
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosSolicitudes\Microservicio MsDatosSolicitudes V1.3.pdf"
    
    content = extract_pdf_content(pdf_path)
    
    # Guardar en archivo de texto
    output_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosSolicitudes\EXTRACCION_PDF.md"
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write("# Extracción del PDF: Microservicio MsDatosSolicitudes V1.3\n\n")
        f.write(content)
    
    print(f"Contenido extraído y guardado en: {output_path}")
    print(f"Total de caracteres: {len(content)}")
