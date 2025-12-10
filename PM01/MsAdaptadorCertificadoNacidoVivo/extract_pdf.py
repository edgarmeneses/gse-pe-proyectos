import sys
try:
    import PyPDF2
    pdf_available = True
except ImportError:
    pdf_available = False
    
try:
    import pdfplumber
    plumber_available = True
except ImportError:
    plumber_available = False

print(f"PyPDF2 available: {pdf_available}")
print(f"pdfplumber available: {plumber_available}")

if plumber_available:
    import pdfplumber
    
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\PM01\MsAdaptadorCertificadoNacidoVivo\p_Microservicio MsAdaptadorCertificadoNacidoVivo V1.2.pdf"
    
    with pdfplumber.open(pdf_path) as pdf:
        print(f"\n=== PDF Analysis ===")
        print(f"Total pages: {len(pdf.pages)}")
        print(f"\n=== CONTENT ===\n")
        
        for i, page in enumerate(pdf.pages, 1):
            print(f"\n--- PAGE {i} ---\n")
            text = page.extract_text()
            print(text)
            
            # Extract tables if any
            tables = page.extract_tables()
            if tables:
                print(f"\n[TABLES FOUND ON PAGE {i}]")
                for j, table in enumerate(tables, 1):
                    print(f"\nTable {j}:")
                    for row in table:
                        print(row)
                        
elif pdf_available:
    import PyPDF2
    
    pdf_path = r"c:\Users\edgar.meneses\Documents\Repos\gse-pe-proyectos\PM01\MsAdaptadorCertificadoNacidoVivo\p_Microservicio MsAdaptadorCertificadoNacidoVivo V1.2.pdf"
    
    with open(pdf_path, 'rb') as file:
        pdf_reader = PyPDF2.PdfReader(file)
        print(f"\n=== PDF Analysis ===")
        print(f"Total pages: {len(pdf_reader.pages)}")
        print(f"\n=== CONTENT ===\n")
        
        for i, page in enumerate(pdf_reader.pages, 1):
            print(f"\n--- PAGE {i} ---\n")
            text = page.extract_text()
            print(text)
else:
    print("\nNo PDF library available. Installing pdfplumber...")
    import subprocess
    subprocess.run([sys.executable, "-m", "pip", "install", "pdfplumber"])
