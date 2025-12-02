import PyPDF2
import re

def extract_pdf_content(pdf_path):
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        full_text = ""
        
        for page_num in range(len(pdf_reader.pages)):
            page = pdf_reader.pages[page_num]
            full_text += f"\n\n=== PÁGINA {page_num + 1} ===\n\n"
            full_text += page.extract_text()
    
    return full_text

# Extraer contenido
pdf_path = "Microservicio MsDatosAgendamiento V1.0.pdf"
content = extract_pdf_content(pdf_path)

# Guardar en archivo de texto
with open("PDF_EXTRACTED_CONTENT.txt", "w", encoding="utf-8") as f:
    f.write(content)

print("Contenido extraído exitosamente a PDF_EXTRACTED_CONTENT.txt")
print(f"Total de caracteres: {len(content)}")
