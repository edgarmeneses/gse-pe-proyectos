import PyPDF2
import sys

pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosParentesco\Microservicio MsDatosParentesco V1.0.pdf"

try:
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        
        print(f"Total pages: {len(pdf_reader.pages)}\n")
        print("="*80)
        print("EXTRACTED CONTENT FROM PDF")
        print("="*80)
        print()
        
        full_text = ""
        for page_num in range(len(pdf_reader.pages)):
            page = pdf_reader.pages[page_num]
            text = page.extract_text()
            full_text += f"\n--- PAGE {page_num + 1} ---\n"
            full_text += text
            
        print(full_text)
        
        # Save to file
        output_file = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDatosParentesco\pdf_extracted_content.txt"
        with open(output_file, 'w', encoding='utf-8') as f:
            f.write(full_text)
        
        print("\n" + "="*80)
        print(f"Content also saved to: {output_file}")
        print("="*80)
        
except Exception as e:
    print(f"Error: {e}")
    sys.exit(1)
