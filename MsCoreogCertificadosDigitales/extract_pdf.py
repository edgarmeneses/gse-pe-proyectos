#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
Script para extraer texto de PDF y guardarlo en formato legible
"""

import PyPDF2
import sys
import os

def extract_pdf_text(pdf_path, output_path):
    """Extrae texto de un PDF y lo guarda en un archivo de texto"""
    try:
        with open(pdf_path, 'rb') as pdf_file:
            # Crear objeto lector de PDF
            pdf_reader = PyPDF2.PdfReader(pdf_file)
            
            # Obtener información del PDF
            num_pages = len(pdf_reader.pages)
            print(f"📄 PDF: {os.path.basename(pdf_path)}")
            print(f"📖 Páginas: {num_pages}")
            print(f"💾 Extrayendo texto...\n")
            
            # Extraer texto de todas las páginas
            full_text = []
            for i, page in enumerate(pdf_reader.pages, 1):
                text = page.extract_text()
                full_text.append(f"\n{'='*80}\n")
                full_text.append(f"PÁGINA {i} de {num_pages}\n")
                full_text.append(f"{'='*80}\n\n")
                full_text.append(text)
                print(f"✓ Página {i}/{num_pages} extraída")
            
            # Guardar en archivo
            with open(output_path, 'w', encoding='utf-8') as output_file:
                output_file.write(''.join(full_text))
            
            print(f"\n✅ Texto extraído exitosamente")
            print(f"📁 Archivo guardado en: {output_path}")
            
            return True
            
    except FileNotFoundError:
        print(f"❌ Error: No se encontró el archivo {pdf_path}")
        return False
    except Exception as e:
        print(f"❌ Error al procesar el PDF: {str(e)}")
        return False

if __name__ == "__main__":
    # Ruta del PDF
    pdf_path = "Microservicio MsCoreogCertificadosDigitales v1.1.pdf"
    output_path = "MsCoreogCertificadosDigitales_v1.1_extracted.txt"
    
    # Verificar que existe el PDF
    if not os.path.exists(pdf_path):
        print(f"❌ No se encontró el archivo: {pdf_path}")
        print(f"📂 Directorio actual: {os.getcwd()}")
        sys.exit(1)
    
    # Extraer texto
    success = extract_pdf_text(pdf_path, output_path)
    
    sys.exit(0 if success else 1)
