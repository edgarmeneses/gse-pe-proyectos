import PyPDF2
import os

pdf_path = 'p_Microservicio MsAdaptadorPagos V1.2.pdf'
output_path = 'PDF_CONTENT.txt'

try:
    if not os.path.exists(pdf_path):
        print(f"Error: File {pdf_path} not found.")
        exit(1)

    text_content = []
    with open(pdf_path, 'rb') as pdf_file:
        pdf_reader = PyPDF2.PdfReader(pdf_file)
        num_pages = len(pdf_reader.pages)
        print(f"Found {num_pages} pages.")
        
        for page_num in range(num_pages):
            page = pdf_reader.pages[page_num]
            text = page.extract_text()
            text_content.append(f"--- Page {page_num + 1} ---\n{text}\n")

    with open(output_path, 'w', encoding='utf-8') as f:
        f.write('\n'.join(text_content))
    
    print(f"Successfully extracted text to {output_path}")

except Exception as e:
    print(f"An error occurred: {e}")
