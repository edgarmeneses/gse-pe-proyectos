import pdfplumber
import sys

pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\MsDominioCotejoMasivo\Microservicio MsDominioCotejoMasivo V1.0.pdf"

try:
    with pdfplumber.open(pdf_path) as pdf:
        print(f"Total pages: {len(pdf.pages)}\n")
        print("="*80)
        
        for i, page in enumerate(pdf.pages, 1):
            print(f"\n{'='*80}")
            print(f"PAGE {i}")
            print(f"{'='*80}\n")
            
            text = page.extract_text()
            if text:
                print(text)
            
            # Also extract tables if any
            tables = page.extract_tables()
            if tables:
                print("\n[TABLES ON THIS PAGE]")
                for j, table in enumerate(tables, 1):
                    print(f"\nTable {j}:")
                    for row in table:
                        print(" | ".join(str(cell) if cell else "" for cell in row))
            
            print(f"\n{'='*80}")
            
except Exception as e:
    print(f"Error: {str(e)}")
    sys.exit(1)
