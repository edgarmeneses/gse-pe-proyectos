#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script para extraer texto de un PDF
"""
import sys

try:
    import PyPDF2
    print("PyPDF2 está instalado")
except ImportError:
    print("PyPDF2 no está instalado. Instalando...")
    import subprocess
    subprocess.check_call([sys.executable, "-m", "pip", "install", "PyPDF2"])
    import PyPDF2

def extract_text_from_pdf(pdf_path, output_path):
    """Extrae texto de un PDF y lo guarda en un archivo de texto"""
    try:
        with open(pdf_path, 'rb') as pdf_file:
            pdf_reader = PyPDF2.PdfReader(pdf_file)
            num_pages = len(pdf_reader.pages)
            print(f"El PDF tiene {num_pages} páginas")
            
            all_text = []
            all_text.append(f"=== EXTRACCIÓN DEL PDF: {pdf_path} ===\n")
            all_text.append(f"=== Total de páginas: {num_pages} ===\n\n")
            
            for page_num in range(num_pages):
                page = pdf_reader.pages[page_num]
                text = page.extract_text()
                all_text.append(f"\n{'='*80}\n")
                all_text.append(f"PÁGINA {page_num + 1}\n")
                all_text.append(f"{'='*80}\n\n")
                all_text.append(text)
            
            # Guardar en archivo
            with open(output_path, 'w', encoding='utf-8') as output_file:
                output_file.write('\n'.join(all_text))
            
            print(f"Texto extraído exitosamente a: {output_path}")
            return True
            
    except Exception as e:
        print(f"Error al extraer el PDF: {str(e)}")
        return False

if __name__ == "__main__":
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsCoreogValidadorDocumentos\Microservicio MsCoreogValidadorDocumentos v1.0.pdf"
    output_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsCoreogValidadorDocumentos\PDF_EXTRACTED_CONTENT.txt"
    
    print("Iniciando extracción del PDF...")
    success = extract_text_from_pdf(pdf_path, output_path)
    
    if success:
        print("¡Extracción completada con éxito!")
    else:
        print("La extracción falló.")
